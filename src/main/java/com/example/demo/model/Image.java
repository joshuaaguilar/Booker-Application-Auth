package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private String description;
	private String imageUrl;
	@ManyToOne
	@JoinColumn(name = "serviceId")
	private ServiceModel service;
	@ManyToOne
	@JoinColumn(name = "travelPackageId")
	private Travelpackage travelPackage;

	public ServiceModel getService() {
		return service;
	}

	public void setService(ServiceModel service) {
		this.service = service;
	}

	public Travelpackage getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(Travelpackage travelPackage) {
		this.travelPackage = travelPackage;
	}

}
