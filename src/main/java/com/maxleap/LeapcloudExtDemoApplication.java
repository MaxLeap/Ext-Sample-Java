package com.maxleap;

import com.maxleap.config.AppModuleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class LeapcloudExtDemoApplication implements CommandLineRunner{

	@Autowired
	private AppModuleConfig appModuleConfig;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(appModuleConfig);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(LeapcloudExtDemoApplication.class, args);
		DataSource dataSource = (DataSource) context.getBean("primaryDataSource");
		AppModuleConfig appModuleConfig = (AppModuleConfig)context.getBean("appModuleConfig");
		appModuleConfig.initDB(dataSource.getConnection());
	}

}
