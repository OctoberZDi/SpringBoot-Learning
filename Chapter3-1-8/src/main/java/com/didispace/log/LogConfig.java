package com.didispace.log;

import com.didispace.web.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: LogConfig <br>
 * date: 2019/12/25 9:43 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@Configuration
public class LogConfig {
    private static final Logger myLogger = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public User testLog() {
        myLogger.info("********log");

        return new User();
    }
}
