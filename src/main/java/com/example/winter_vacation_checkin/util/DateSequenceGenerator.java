package com.example.winter_vacation_checkin.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author 徐扬
 * @since 2026/2/2 14:22
 */

/**
 * 日期+序列组合法 - 生成有意义的短编码
 * 格式：年月日(6位) + 当日序列(3位) = 9位数字
 * 示例：231228001 (2023年12月28日第1个用户)
 */

public class DateSequenceGenerator {

    private final Map<String, AtomicInteger> dailyCounter = new ConcurrentHashMap<>();

    /**
     * 生成带日期的9位数字编码
     */
    public int generateDateBasedCode(long snowflakeId) {
        // 从雪花ID中提取时间戳（雪花算法的时间戳是前41位）
        long timestamp = extractTimestamp(snowflakeId);

        // 转换为日期
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String dateStr = sdf.format(date);  // 如：231228

        // 获取当日的序列号
        AtomicInteger counter = dailyCounter.computeIfAbsent(
                dateStr, k -> new AtomicInteger(0)
        );

        int sequence = counter.incrementAndGet();

        // 限制序列号为3位数（1-999）
        if (sequence > 999) {
            sequence = sequence % 1000;
            if (sequence == 0) sequence = 1;
            counter.set(sequence);
        }

        // 组合：6位日期 + 3位序列
        String fullCodeStr = dateStr + String.format("%03d", sequence);

        return Integer.parseInt(fullCodeStr);  // 9位数字
    }

    /**
     * 从雪花ID提取时间戳
     */
    private long extractTimestamp(long snowflakeId) {
        // 雪花算法：时间戳是前41位
        // 需要加上起始时间戳（Twitter雪花算法起始：1288834974657L）
        long twepoch = 1288834974657L;
        long timestamp = (snowflakeId >> 22) + twepoch;
        return timestamp;
    }

}
