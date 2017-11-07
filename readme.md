### 第三方模块JAVA实现样例

#### 功能
实现一个web项目，基于spring-boot，可以操作mysql云数据源

#### 代码实现
框架核心结构：spring-boot,包括web/thymeleaf/jpa插件

数据源配置通过环境变量加载，测试数据库可以参考[test_user.sql](src/main/resources/test_user.sql)

所有请求的基础访问路径为`/ext/{prefix}`，prefix为第三方模块URL前缀，也是通过环境变量加载进来

#### 本地测试
单元测试或启动main程序需要预设环境变量，需要哪些变量可以参考[AppModuleConfig.java](src/main/java/com/maxleap/config/AppModuleConfig.java)


#### 快速发布模块镜像
执行命令：`mvn clean package -DpushImage` 即可本地构建镜像并上传到服务器
