package com.xinyan.boot.task;

import com.system.commons.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author 孟星魂
 * @version 5.0 createTime: 2019/8/16
 */
@Slf4j
@Service
@EnableScheduling
public class MyCountTask {

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void count() {
        log.info("打印时间,{}", DateUtil.format(new Date(),DateUtil.settlePattern));
    }

}
