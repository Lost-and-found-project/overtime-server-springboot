package org.overtime.common.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.overtime.common.PageInfo;
import org.overtime.common.Paged;
import org.overtime.common.service.utils.CountDistinctFunction;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.core.StatementMapper;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.sql.Functions;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.PreparedOperation;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * 针对于 {@link R2dbcEntityTemplate} 而提供的一些扩展操作，比如字段去重、COUNT去重等。
 *
 * @author ForteScarlet
 */
@Slf4j
@RequiredArgsConstructor
public class OvertimeR2dbcEntityTemplate {
    @Getter
    private final R2dbcEntityTemplate r2dbcEntityTemplate;


    public <T> Mono<Paged<T>> selectPaged(Class<T> resultType, Class<?> tableType, Query query, boolean distinct) {
        final SqlIdentifier table = r2dbcEntityTemplate.getDataAccessStrategy().getTableName(tableType);

        final List<SqlIdentifier> identifierColumns = r2dbcEntityTemplate.getDataAccessStrategy().getIdentifierColumns(tableType);
        if (identifierColumns.size() != 1) {
            throw new IllegalArgumentException("IdentifierColumns size must be 1.");
        }
        final SqlIdentifier id = identifierColumns.get(0);

        final StatementMapper statementMapper = r2dbcEntityTemplate.getDataAccessStrategy().getStatementMapper();
        final int limit = query.getLimit();
        final long offset = query.getOffset();
        StatementMapper.SelectSpec spec = statementMapper.createSelect(table).withSort(query.getSort());

        StatementMapper.SelectSpec spec0 = spec;

        final Optional<CriteriaDefinition> criteria = query.getCriteria();
        if (criteria.isPresent()) {
            spec = criteria.map(spec0::withCriteria).orElse(spec);
        }


        StatementMapper.SelectSpec listSpec = listSpec(spec, limit, offset, query.getColumns(), distinct);
        StatementMapper.SelectSpec countSpec = countSpec(spec, id, distinct);


        final PreparedOperation<?> listOperation = statementMapper.getMappedObject(listSpec);
        final PreparedOperation<?> countOperation = statementMapper.getMappedObject(countSpec);

        final DatabaseClient client = r2dbcEntityTemplate.getDatabaseClient();
        final Flux<T> list = client.sql(listOperation).map(r2dbcEntityTemplate.getDataAccessStrategy().getRowMapper(resultType)).all();
        final Mono<PageInfo> pageInfo = client.sql(countOperation).map(r -> r.get(0, Long.class)).first().map(total -> PageInfo.toPageInfo(total, limit, limit == 0 ? 0 : (int) (offset / limit)));
        return Paged.toPaged(list, pageInfo);
    }

    private StatementMapper.SelectSpec listSpec(StatementMapper.SelectSpec spec, int limit, long offset, List<SqlIdentifier> columns, boolean distinct) {
        spec = spec.limit(limit)
                .offset(offset);
        if (distinct) {
            spec = spec.distinct();
        }

        return spec.doWithTable((table, sp) -> {
            if (columns.isEmpty()) {
                return sp.withProjection(table.asterisk());
            } else {
                return sp.withProjection(columns.stream().map(table::column).collect(Collectors.toList()));
            }
        });

    }


    private StatementMapper.SelectSpec countSpec(StatementMapper.SelectSpec spec, SqlIdentifier id, boolean distinct) {
        return spec.doWithTable((table, sp) -> {
            if (distinct) {
                return sp.withProjection(CountDistinctFunction.getInstance(table.column(id)));
            } else {
                return sp.withProjection(Functions.count(table.column(id)));
            }
        });

    }

}
