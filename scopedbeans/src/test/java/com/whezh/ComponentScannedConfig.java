package com.whezh;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 默认扫描与配置相同的包，这里指定了不适合组件扫描的类型。
@ComponentScan(excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ComponentScannedConfig {
}
