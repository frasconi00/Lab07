package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;

public class PowerOutage {
	
	private int id;
	private int eventTypeId;
	private int tagId;
	private int areaId;
	private int nercId;
	private int responsibleId;
	private int customersAffected;
	private LocalDateTime dateEventBegan;
	private LocalDateTime dateEventFinished;
	//lascio demandLoss che spesso è null
	
	public PowerOutage(int id, int eventTypeId, int tagId, int areaId, int nercId, int responsibleId,
			int customersAffected, LocalDateTime dateEventBegan, LocalDateTime dateEventFinished) {
		this.id = id;
		this.eventTypeId = eventTypeId;
		this.tagId = tagId;
		this.areaId = areaId;
		this.nercId = nercId;
		this.responsibleId = responsibleId;
		this.customersAffected = customersAffected;
		this.dateEventBegan = dateEventBegan;
		this.dateEventFinished = dateEventFinished;
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getNercId() {
		return nercId;
	}

	public void setNercId(int nercId) {
		this.nercId = nercId;
	}

	public int getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(int responsibleId) {
		this.responsibleId = responsibleId;
	}

	public int getCustomersAffected() {
		return customersAffected;
	}

	public void setCustomersAffected(int customersAffected) {
		this.customersAffected = customersAffected;
	}

	public LocalDateTime getDateEventBegan() {
		return dateEventBegan;
	}

	public void setDateEventBegan(LocalDateTime dateEventBegan) {
		this.dateEventBegan = dateEventBegan;
	}

	public LocalDateTime getDateEventFinished() {
		return dateEventFinished;
	}

	public void setDateEventFinished(LocalDateTime dateEventFinished) {
		this.dateEventFinished = dateEventFinished;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutage other = (PowerOutage) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PowerOutage [id=" + id + ", nercId=" + nercId + ", customersAffected=" + customersAffected
				+ ", dateEventBegan=" + dateEventBegan + ", dateEventFinished=" + dateEventFinished + "]";
	}
	
	
}
