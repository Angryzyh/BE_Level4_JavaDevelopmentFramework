package com.angryzyh.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
@SpringBootTest
public class TestTime {
    @Autowired
    private UnitConfig unitConfig;

    //加载配置文件时间参数
    @Test
    public void test01() {
        System.out.println(unitConfig);
        Duration days = unitConfig.getDays();
        System.out.println("days = " + days);
        //追加时间
        Duration plus = days.plus(1, ChronoUnit.DAYS);
        System.out.println("plus = " + plus);
        //减去时间
        long minus = plus.minus(20, ChronoUnit.HOURS).toMillis()/1000;
        System.out.println("minus = " + minus);
    }

    //测试两个日期之间差值 Duration.between()  duration.toHours()
    @Test
    public void test02() {
        Instant start = Instant.parse("2021-04-13T13:52:30.00Z");
        Instant end = Instant.parse("2021-04-14T10:16:30.00Z");
        Duration duration = Duration.between(start, end);
        log.info("start 和 end 之间的时差值天:{},小时：{},分钟：{},秒：{},毫秒:{},纳秒：{}"
                ,duration.toDays(),duration.toHours(),duration.toMinutes()
                ,duration.getSeconds(),duration.toMillis(),duration.toNanos());
    }

    //测试两个日期先后 Duration.between(x,y)  duration.isNegative()  判断 x>y
    @Test
    public void test03() {
        Instant start = Instant.parse("2021-04-13T13:52:30.00Z");
        Instant end = Instant.parse("2021-04-14T10:16:30.00Z");
        Duration duration = Duration.between(end,start);
        log.info("end 是否大于 start ：{}",duration.isNegative());
        Duration duration2 = Duration.between(start,end);
        log.info("start 是否大于 end ：{}",duration2.isNegative());
    }

    //测试log 输出 加减转换
    @Test
    public void test04() {
        Duration duration = Duration.parse("P1DT5H20M34.42S");
        log.info("转换的时间为  天：{}、小时：{}、分钟：{}、秒：{}、毫秒：{}、纳秒：{}"
                ,duration.toDays(),duration.toHours(),duration.toMinutes(),duration.getSeconds(),duration.toMillis(),duration.toNanos());
        Duration duration2 = duration.parse("P1DT-5H");
        log.info("转换的时间为  天：{}、小时：{}、分钟：{}、秒：{}、毫秒：{}、纳秒：{}"
                ,duration2.toDays(),duration2.toHours(),duration2.toMinutes(),duration2.getSeconds(),duration2.toMillis(),duration2.toNanos());
        /* 单独对天、时、分、秒、毫秒、纳秒 增加或减 */
        log.info("添加指定时间后的结果为   天：{}、小时：{}、分钟：{}、秒：{}、毫秒：{}、纳秒：{}",
                duration2.plus(1,ChronoUnit.DAYS).toDays(),duration2.plus(6,ChronoUnit.HOURS).toHours(),
                duration2.plus(5,ChronoUnit.MINUTES).toMinutes(),duration2.plus(10,ChronoUnit.SECONDS).getSeconds(),
                duration2.plus(10,ChronoUnit.MILLIS).toMillis(),duration2.plus(5,ChronoUnit.NANOS).toNanos());
        log.info("减去指定时间后的结果为   天：{}、小时：{}、分钟：{}、秒：{}、毫秒：{}、纳秒：{}",
                duration2.minusDays(1).toDays(),duration2.minusHours(6).toHours(),
                duration2.minusMinutes(5).toMinutes(),duration2.minusSeconds(10).getSeconds(),
                duration2.minusMillis(10).toMillis(),duration2.minusNanos(5).toNanos());
        /* 使用Duration.ofX()创建指定时间的Duration对象 */
        Duration days = Duration.ofDays(2);
        Duration hours = Duration.ofHours(1);
        Duration minutes = Duration.ofMinutes(50);
        Duration seconds = Duration.ofSeconds(5000);
        Duration millis = Duration.ofMillis(50000);
        Duration nanos = Duration.ofNanos(600000);
        log.info("天：{}，小时：{}，分钟：{}，秒：{}，毫秒：{}，纳秒：{}",days.toDays(),hours.toHours(),minutes.toMinutes(),seconds.getSeconds(),millis.toMillis(),nanos.toNanos());

        /* 使用Duration.toX()转换时间格式 */
        log.info("分钟：{}，秒：{}",hours.toMinutes(),minutes.getSeconds());
    }
}
