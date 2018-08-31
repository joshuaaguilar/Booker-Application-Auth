
package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonIdentityInfo(generator = PropertyGenerator.class, property = "serviceId")

public class ServiceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	private String serviceName;
	private String description;
	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
	private List<Image> images;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "travelPackageId")
	private Travelpackage travelpackage;

	public Travelpackage getTravelpackage() {
		return travelpackage;
	}

	public void setTravelpackage(Travelpackage travelpackage) {
		this.travelpackage = travelpackage;
	}

}
