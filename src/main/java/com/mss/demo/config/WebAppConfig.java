package com.mss.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@ComponentScan("com.mss.demo.controller")
@EnableAutoConfiguration
public class WebAppConfig {

}
