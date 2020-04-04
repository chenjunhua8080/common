package com.cjh.common.job;

import com.cjh.common.api.FarmApi;
import com.cjh.common.util.DateUtil;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 农场定时任务
 *
 * @author cjh
 * @date 2020/4/3
 */
@AllArgsConstructor
@EnableScheduling
@Component
@Slf4j
public class FarmJob {

    private FarmApi farmApi;

    @Scheduled(cron = "${job.farm.gotThreeMealForFarm}")
    public void gotThreeMealForFarm() {
        log.info("#### 定时任务[水滴 - 三餐] 开始: {} ####", DateUtil.format(new Date()));
        farmApi.gotThreeMealForFarm();
        log.info("#### 定时任务[水滴 - 三餐] 结束: {} ####", DateUtil.format(new Date()));

    }

    @Scheduled(cron = "${job.farm.signForFarm}")
    public void signForFarm() {
        log.info("#### 定时任务[水滴 - 签到] 开始: {} ####", DateUtil.format(new Date()));
        farmApi.signForFarm();
        log.info("#### 定时任务[水滴 - 签到] 结束: {} ####", DateUtil.format(new Date()));

    }

    @Scheduled(cron = "${job.farm.waterGoodForFarm}")
    public void waterGoodForFarm() {
        log.info("#### 定时任务[水滴 - 浇水] 开始: {} ####", DateUtil.format(new Date()));
        farmApi.waterGoodForFarm();
        log.info("#### 定时任务[水滴 - 浇水] 结束: {} ####", DateUtil.format(new Date()));
    }

    @Scheduled(cron = "${job.farm.firstWaterTaskForFarm}")
    public void firstWaterTaskForFarm() {
        log.info("#### 定时任务[水滴 - 首浇奖励] 结束: {} ####", DateUtil.format(new Date()));
        farmApi.firstWaterTaskForFarm();
        log.info("#### 定时任务[水滴 - 首浇奖励] 结束: {} ####", DateUtil.format(new Date()));
    }

}