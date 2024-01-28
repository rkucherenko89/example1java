package com.example.services;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component()
public class VehicleService {
	private Logger logger = Logger.getLogger(VehicleService.class.getName());
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

	@LogAspect
	public String playMusic(boolean vehicleStarted) {
		return speakers.makeSound();
	}

	public void moveVehicle() {
		System.out.println(tyres.rotate());
	}
}
