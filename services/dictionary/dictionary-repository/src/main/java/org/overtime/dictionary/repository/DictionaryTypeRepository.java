package org.overtime.dictionary.repository;

import org.overtime.dictionary.domain.DictionaryType;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * 字典类型 repository.
 *
 * @see DictionaryType
 * @author ForteScarlet
 */
@Repository
public interface DictionaryTypeRepository extends R2dbcRepository<DictionaryType, Long> {
}
