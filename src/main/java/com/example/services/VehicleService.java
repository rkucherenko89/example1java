package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("service")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VehicleService {
	@Autowired
	private Speakers speakers;
	private Tyres tyres;

	public Speakers getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Speakers speakers) {
		this.speakers = speakers;
	}

	public Tyres getTyres() {
		return tyres;
	}

	@Autowired
	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}

	public void playMusic() {
		System.out.println(speakers.makeSound());
	}

	public void moveVehicle() {
		System.out.println(tyres.rotate());
	}
}
