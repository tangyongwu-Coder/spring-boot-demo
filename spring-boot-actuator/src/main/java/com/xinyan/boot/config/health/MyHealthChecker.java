package com.xinyan.boot.config.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/8/19
 */
@Component("my1")
public class MyHealthChecker implements HealthIndicator {
    private String status;
    @Override
    public Health health() {
        //自定义监控内容
        if ("up".equals(status)) {
            return new Health.Builder().withDetail("status", "up").up().build();
        }else if("down".equals(status)){
            return new Health.Builder().withDetail("error", "client is down").down().build();
        }else if("outOfService".equals(status)){
            return new Health.Builder().withDetail("error", "client is outOfService").outOfService().build();
        }else{
            return new Health.Builder().withDetail("error", "client is unknown").unknown().build();
        }
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
