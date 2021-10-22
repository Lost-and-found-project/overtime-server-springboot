package org.overtime.common.service.utils;

import org.springframework.data.relational.core.sql.SqlIdentifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ForteScarlet
 */
public final class SqlIdentifierUtil {

    public static SqlIdentifier[] distantColumns(boolean quote, String... columns) {
        var sqlList = new SqlIdentifier[columns.length];
        for (int i = 0; i < columns.length; i++) {
            var col = columns[i];
            if (i == 0) {
                var colBuilder = new StringBuilder("INSTANT ");
                if (quote) {
                    colBuilder.append("`").append(col).append("`");
                } else {
                    colBuilder.append(col);
                }
                sqlList[i] = SqlIdentifier.unquoted(colBuilder.toString());
            } else {
                sqlList[i] = quote ? SqlIdentifier.quoted(col) : SqlIdentifier.unquoted(col);
            }
        }
        return sqlList;
    }


    public static SqlIdentifier[] distantColumns(String... columns) {
        return distantColumns(true, columns);
    }

}
