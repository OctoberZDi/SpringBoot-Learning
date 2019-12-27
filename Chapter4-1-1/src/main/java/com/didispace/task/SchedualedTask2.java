package com.didispace.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description: SchedualedTask2 <br>
 * date: 2019/12/27 14:04 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Component
public class SchedualedTask2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 3000)
    public void doPrintLog() {
        System.err.println("北京时间：" + dateFormat.format(new Date()));
    }
}
