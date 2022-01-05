package org.overtime.common.auth;

import org.jetbrains.annotations.NotNull;

/**
 * 用户信息。
 * <p>
 * 一个用户可能属于多个角色。
 *
 * @author ForteScarlet
 */
public interface UserInfo {

    /**
     * 获取用户的用户名。此用户名应当唯一。
     *
     * @return username
     */
    @NotNull
    String getUsername();

    /**
     * 得到此用户的密码。密码可能是加密后的。
     *
     * @return password
     */
    String getPassword();

    /**
     * 此用户当前是否可用。
     *
     * @return 如果可用则为true
     */
    boolean enabled();

}
