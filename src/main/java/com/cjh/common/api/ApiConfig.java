package com.cjh.common.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 共用动态配置
 *
 * @author cjh
 * @date 2020/4/3
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "api")
@Data
public class ApiConfig {

    private TestConfig testConfig;
    private FarmConfig farmConfig;
    private CakeConfig cakeConfig;
    private BankChinaConfig bankChinaConfig;
    private PetsConfig petsConfig;
    private BossConfig bossConfig;

    @Data
    public static class TestConfig {

        private Boolean working;
    }

    @Data
    public static class FarmConfig {

        private Boolean working;
    }

    @Data
    public static class CakeConfig {

        private Boolean working;
    }

    @Data
    public static class BankChinaConfig {

        private Boolean working;
    }

    @Data
    public static class PetsConfig {

        private Boolean working;
    }

    @Data
    public static class BossConfig {

        private Boolean emailWorking;
        private String subjectMatch;
    }

}
