package com.xinyan.boot.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 优雅停机controller
 *
 * @author lang_li
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/shutdown")
public class ShutdownController {
    @Value("${management.server.port}")
    private int port;
    @Value("${service.down.sleep:30000}")
    private int sleep;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 停机服务
     */
    @ResponseBody
    @RequestMapping(value = "/stop", method = {RequestMethod.POST,
            RequestMethod.GET})
    @ApiOperation(value = "停机服务", notes = "停机服务")
    public void stop() {
        try {
            log.info("下线开始,port:{}", port);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.spring-boot.actuator.v2+json;charset=UTF-8");
            headers.add(HttpHeaders.CONTENT_ENCODING, "UTF-8");
            restTemplate.postForObject("http://localhost:" + port +
                            "/management/service-registry?status=DOWN",
                    new HttpEntity<>(headers), Object.class);
            Thread.sleep(sleep);
            headers.add(HttpHeaders.USER_AGENT, "application/x-www-form-urlencoded");
            headers.add(HttpHeaders.CONTENT_TYPE, "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            restTemplate.postForObject("http://localhost:" + port +
                            "/management/shutdown",
                    new HttpEntity<>(headers), Object.class);
            Thread.sleep(2000);
            log.info("下线结束...");
        } catch (Exception e) {
            log.error("停机异常:{}", e);
        }
    }


}