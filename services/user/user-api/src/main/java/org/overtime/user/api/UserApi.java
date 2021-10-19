package org.overtime.user.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author ForteScarlet
 */
@FeignClient("user")
public interface UserApi {



}
