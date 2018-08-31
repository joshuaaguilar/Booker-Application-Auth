
package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "serviceId")
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

	public List<Travelpackage> getTravelpackages() {
		return travelpackages;
	}

	public void setTravelpackages(List<Travelpackage> travelpackages) {
		this.travelpackages = travelpackages;
	}

	private String serviceName;
	private String description;
	@OneToMany
	private List<Image> images;
	@ManyToOne(targetEntity = Travelpackage.class)
	private List<Travelpackage> travelpackages;
}
