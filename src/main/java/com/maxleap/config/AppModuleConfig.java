package com.maxleap.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 应用配置，包括数据源信息，需要从环境变量加载
 * User：David Young
 * Date：2017/11/6
 */
@Configuration
@EnableTransactionManagement
public class AppModuleConfig implements EnvironmentAware{

  private String prefix;
  private String appId;
  private String restAPIKey;
  private String masterKey;
  private String url;
  private String user;
  private String password;

  public String prefix(){
    return "/ext/"+prefix;
  }

  @Bean
  public DataSource primaryDataSource(){
    return DataSourceBuilder.create()
        .driverClassName("com.mysql.jdbc.Driver")
        .username(user)
        .password(password)
        .url("jdbc:mysql://"+url+"?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true")
        .build();
  }

  @Override
  public void setEnvironment(Environment environment) {
    this.prefix = environment.getProperty("prefix");
    this.appId = environment.getProperty("appId");
    this.restAPIKey = environment.getProperty("restAPIKey");
    this.masterKey = environment.getProperty("masterKey");
    this.url = environment.getProperty("leapCloudMysqlUrl");
    this.user = environment.getProperty("leapCloudMysqlUser");
    this.password = environment.getProperty("leapCloudMysqlPassword");
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getRestAPIKey() {
    return restAPIKey;
  }

  public void setRestAPIKey(String restAPIKey) {
    this.restAPIKey = restAPIKey;
  }

  public String getMasterKey() {
    return masterKey;
  }

  public void setMasterKey(String masterKey) {
    this.masterKey = masterKey;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "AppModuleConfig{" +
        "prefix='" + prefix + '\'' +
        ", appId='" + appId + '\'' +
        ", restAPIKey='" + restAPIKey + '\'' +
        ", masterKey='" + masterKey + '\'' +
        ", url='" + url + '\'' +
        ", user='" + user + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
