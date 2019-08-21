package com.xinyan.boot.config.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/5/14
 */
@Component("my2")
public class MyAbstractHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //自定义监控内容
        if (up) {
            builder.withDetail("status", "up").up().build();
        } else {
            builder.withDetail("error", "client is down").down().build();
        }

    }
    private boolean up = true;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
