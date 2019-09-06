package com.xinyan.boot.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/5/14
 */
@Endpoint(id = "mxh")
@Component
public class MyEndPoint {

    @ReadOperation
    public Map<String, String> hello() {
        Map<String, String> result = new HashMap<>();
        result.put("author", "孟星魂");
        result.put("age", "18");
        result.put("email", "yongwu_tang@xinyan.com");
        return result;
    }
}
