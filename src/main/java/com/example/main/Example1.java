package com.example.main;

import com.example.config.ProjectConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		VehicleService service = context.getBean(VehicleService.class);
		String music = service.playMusic(true);
		System.out.println(music);
	}
}
