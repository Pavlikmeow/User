package com.shop.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(name = "ms-content", url = "${feign.content.url}")
@FeignClient(name = "ms-content", url = "url")
public interface Client {

    @PostMapping("some http")
    void methodName(Object something);
}
