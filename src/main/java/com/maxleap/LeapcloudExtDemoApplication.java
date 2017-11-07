package com.maxleap;

import com.maxleap.config.AppModuleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeapcloudExtDemoApplication implements CommandLineRunner{

	@Autowired
	private AppModuleConfig appModuleConfig;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(appModuleConfig);
	}

	public static void main(String[] args) {
		SpringApplication.run(LeapcloudExtDemoApplication.class, args);
	}

}
