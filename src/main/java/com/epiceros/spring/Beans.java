package com.epiceros.spring;

import com.epiceros.util.WebDriverFacade;
import com.epiceros.util.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Beans {

    @Bean
    public WebDriverFacade webDriver() {
        long timeout = Long.parseLong(System.getProperty("wd.wait.timeout", "30"));
        return new WebDriverFacade(WebDriverFactory.getDriver(), Duration.ofSeconds(timeout));
    }
}
