package com.xinyan.boot.controller;

import com.system.commons.utils.DateUtil;
import com.xinyan.boot.config.health.MyHealthChecker;
import com.xinyan.boot.exception.MyException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/8/19
 */
@Slf4j
@CrossOrigin
@RestController
@Api(value = "test", tags = "测试接口", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private MyHealthChecker myHealthChecker;
    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public String log() {
        log.debug("debug日志,打印时间,{}", DateUtil.format(new Date(),DateUtil.settlePattern));
        log.info("info日志,打印时间,{}", DateUtil.format(new Date(),DateUtil.settlePattern));
        return "hello world";
    }




    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String testHello() {
        long l1 = System.currentTimeMillis();
        Random random = new Random();
        int result =random.nextInt(1000);
        long l = result + 500L;

        try{
            Thread.sleep(l);
        }catch (Exception e){

        }
        log.info("耗时{}",System.currentTimeMillis() - l1);
        return "hello world";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String testHello1() {
        return "hello world1";
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String testHello2() {
        return "hello world2";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String testError() {
        log.info("来了哈error");
        throw new MyException("1","2");
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String testPost() {
        return "hello world";
    }

    @RequestMapping(value = "/up", method = RequestMethod.GET)
    public String up() {
        myHealthChecker.setStatus("up");
        return myHealthChecker.getStatus();
    }
    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public String down() {
        myHealthChecker.setStatus("down");
        return myHealthChecker.getStatus();
    }
    @RequestMapping(value = "/outOfService", method = RequestMethod.GET)
    public String outOfService() {
        myHealthChecker.setStatus("outOfService");
        return myHealthChecker.getStatus();
    }
    @RequestMapping(value = "/unknown", method = RequestMethod.GET)
    public String unknown() {
        myHealthChecker.setStatus("unknown");
        return myHealthChecker.getStatus();
    }
}
