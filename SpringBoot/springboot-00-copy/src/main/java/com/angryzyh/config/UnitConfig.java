package com.angryzyh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@Component
@Validated //开启数据校验
@ConfigurationProperties(prefix = "unit") //加载配置文件输入导入pojo属性
public class UnitConfig {
    @Max(value = 10000000,message = "过长")
    private Integer sss;

    //日期类
    //纳秒
    @DurationUnit(ChronoUnit.NANOS)
    private Duration nanos;

    //微秒
    @DurationUnit(ChronoUnit.MICROS)
    private Duration micros;

    //毫秒
    @DurationUnit(ChronoUnit.MILLIS)
    private Duration millis;

    //秒
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration seconds;

    //分钟
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration minutes;

    //小时
    @DurationUnit(ChronoUnit.HOURS)
    private Duration hours;

    //天
    @DurationUnit(ChronoUnit.DAYS)
    private Duration days;

    //数据类
    //B byte
    @DataSizeUnit(DataUnit.BYTES)
    private DataSize bytes;

    //KB
    @DataSizeUnit(DataUnit.KILOBYTES)
    private DataSize kilobytes;

    //MB
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize megabytes;

    //GB
    @DataSizeUnit(DataUnit.GIGABYTES)
    private DataSize gigabytes;

    //TB
    @DataSizeUnit(DataUnit.TERABYTES)
    private DataSize terabytes;

    //测试
    @DurationUnit(ChronoUnit.MINUTES)
    private Duration timetemp;
}
