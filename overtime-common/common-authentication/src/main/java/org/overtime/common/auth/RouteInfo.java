package org.overtime.common.auth;

/**
 * 表示一个"路由"信息, 也就是URL中的 {@code path} 部分。
 * <p>
 * 路由可能代表为一个具体的路由，例如 {@code /user/info/me},
 * 也可能是一个代表为类glob表达式的路由，例如 {@code /user/**}。
 *
 * @author ForteScarlet
 */
public interface RouteInfo {

    /**
     * 当前的路由的表达式。
     *
     * @return route
     */
    String getRoute();


    /**
     * 检测提供的参数路由是否符合当前路由的规则。
     * <p>
     * 例如当前路由为 {@code /user/**}，
     * 则 {@code /user/info/me}、
     * {@code /user/list} 均符合要求。
     *
     * @param route 检测路由
     * @return 是否匹配。
     */
    boolean checkRoute(String route);

}
