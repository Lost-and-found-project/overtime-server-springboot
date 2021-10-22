package org.overtime.admin.bean.vo;

import java.time.LocalDateTime;

/**
 * 管理用户基本信息。
 * @author ForteScarlet
 */
public interface AdminUserViewSupport {

    Integer getId();
    String getUsername();
    LocalDateTime getCreateTime();
    Short getStatus();


}
