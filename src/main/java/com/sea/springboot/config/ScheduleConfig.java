package com.sea.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class ScheduleConfig {

    /**
     * 每天0点执行
     */
    @Scheduled(cron = "0 0 0 * * ?")
    private void exec() {
        log.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓每天0点定时任务执行↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

        log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑每天0点定时任务执行↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }
}
