package io.egen.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reading {
	@Id
	String id;
	
	public Reading() {
        this.id = UUID.randomUUID()
                      .toString();
    }
	
	String vin;
	double latitude,longitude;
	Date timestamp;
	double fuelVolume;
	int speed;
	int engineHp;
	boolean checkEngineLightOn, engineCoolantLow, cruiseControlOn;
	int engineRpm;
	
	//THIS ANNOTATION IS IMPORTANT
	@OneToOne(fetch= FetchType.EAGER, cascade =  CascadeType.ALL)
	Tires tires; 
	
	@Override
	public String toString() {
		return "Reading [vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude + ", timestamp="
				+ timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp=" + engineHp
				+ ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires=" + tires + "]";
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public double getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}
	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public int getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}
}
