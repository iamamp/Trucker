package io.egen.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tires {
	@Id
	String id;
	
	public Tires() {
        this.id = UUID.randomUUID()
                      .toString();
    }
	
	int frontLeft, frontRight, rearLeft, rearRight;

	@Override
	public String toString() {
		return "Tires [id=" + id + ", frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", rearLeft=" + rearLeft
				+ ", rearRight=" + rearRight + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(int frontLeft) {
		this.frontLeft = frontLeft;
	}

	public int getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(int frontRight) {
		this.frontRight = frontRight;
	}

	public int getRearLeft() {
		return rearLeft;
	}

	public void setRearLeft(int rearLeft) {
		this.rearLeft = rearLeft;
	}

	public int getRearRight() {
		return rearRight;
	}

	public void setRearRight(int rearRight) {
		this.rearRight = rearRight;
	}
}
