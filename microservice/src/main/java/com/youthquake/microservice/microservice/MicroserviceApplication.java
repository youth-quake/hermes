package com.youthquake.microservice.microservice;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.youthquake.microservice.microservice.controller.TargetMicroservice;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) throws IOException {
		TargetMicroservice ts = SpringApplication
				.run(MicroserviceApplication.class, args)
				.getBean(TargetMicroservice.class);
	}
}
