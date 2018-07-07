package com.genil.spring.multipart.demofileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoFileUploadApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoFileUploadApplication.class, args);
	}
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(DemoFileUploadApplication.class);
//	}
}
