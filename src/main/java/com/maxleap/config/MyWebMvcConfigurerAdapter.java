package com.maxleap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 修改静态资源访问路径
 * User：David Young
 * Date：2017/11/6
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

  @Autowired
  private WebMvcProperties webMvcProperties;

  @Autowired
  private AppModuleConfig appModuleConfig;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    webMvcProperties.setStaticPathPattern(appModuleConfig.prefix() + "/**");
    super.addResourceHandlers(registry);
  }
}
