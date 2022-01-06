package org.overtime.common.auth;

/**
 * 权限信息。
 * <p>
 * 一个权限可以包含授权了多个 {@link RouteInfo 路由信息}.
 *
 * @author ForteScarlet
 */
public interface AuthInfo {

    /**
     * 得到此权限的ID。
     *
     * @return id
     */
    Integer getId();


}
