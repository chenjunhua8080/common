package com.cjh.common.controller;

import com.cjh.common.api.JDApi;
import com.cjh.common.dao.BindFarmDao;
import com.cjh.common.enums.PlatformEnum;
import com.cjh.common.feign.CloudFeignClient;
import com.cjh.common.po.BindFarmPO;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class JDController {

    private JDApi jdApi;
    private BindFarmDao bindFarmDao;
    private CloudFeignClient feignClient;

    @GetMapping("/continuousFeed")
    public String continuousFeed(@RequestParam("openId") String openId, @RequestParam("count") Integer count) {
        BindFarmPO bindFarmPO = bindFarmDao.selectByOpenId(openId, PlatformEnum.JD_PETS.getCode());
        if (bindFarmPO == null) {
            return "未绑定";
        }
        String result = jdApi.continuousFeed(count, openId, bindFarmPO.getCookie());
        feignClient.tempPush(openId, result);
        return result;
    }

    @GetMapping("/getHomeData")
    public String getHomeData(@RequestParam("openId") String openId) {
        BindFarmPO bindFarmPO = bindFarmDao.selectByOpenId(openId, PlatformEnum.JD_CAKE.getCode());
        if (bindFarmPO == null) {
            return "未绑定";
        }
        return jdApi.getHomeData(openId, bindFarmPO.getCookie(), false);
    }

    @GetMapping("/countCollectScore")
    public String countCollectScore(@RequestParam("openId") String openId,
        @RequestParam(name = "date", required = false) Date date) {
        BindFarmPO bindFarmPO = bindFarmDao.selectByOpenId(openId, PlatformEnum.JD_CAKE.getCode());
        if (bindFarmPO == null) {
            return "未绑定";
        }
        return jdApi.countCollectScore(openId, date);
    }

}
