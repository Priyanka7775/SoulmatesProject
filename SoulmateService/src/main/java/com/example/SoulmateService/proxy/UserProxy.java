package com.example.SoulmateService.proxy;

import com.example.SoulmateService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//public interface UserProxy {
//}
@FeignClient(name = "authentication-service",url = "http://localhost:8098")
public interface UserProxy {
    @PostMapping("/user/register")
    ResponseEntity<?> saveUser(@RequestBody User user);
}

