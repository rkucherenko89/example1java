package com.example.implementations;

import com.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class SonySpeakers implements Speakers {
	public String makeSound() {
		return "Sony is playing...";
	}
}
