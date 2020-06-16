package io.egen.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alert {
	@Id
	String id;
	
	public Alert() {
        this.id = UUID.randomUUID()
                      .toString();
    }
	
	String vin;
	Date timestamp;
	String descr;
	String priority;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String desc) {
		this.descr = desc;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Alert [id=" + id + ", vin=" + vin + ", timestamp=" + timestamp + ", desc=" + descr + ", priority="
				+ priority + "]";
	}
	
	
}
