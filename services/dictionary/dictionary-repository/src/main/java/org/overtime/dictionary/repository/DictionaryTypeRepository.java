package org.overtime.dictionary.repository;

import org.overtime.common.repository.StandardOvertimeRepository;
import org.overtime.dictionary.domain.DictionaryType;
import org.springframework.stereotype.Repository;

/**
 * 字典类型 repository.
 *
 * @author ForteScarlet
 * @see DictionaryType
 */
@Repository
public interface DictionaryTypeRepository extends StandardOvertimeRepository<DictionaryType, Long> {
}
