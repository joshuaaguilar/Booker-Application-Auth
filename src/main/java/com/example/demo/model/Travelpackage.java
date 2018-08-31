
package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Travelpackage {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelPackageId;
	private String packageName;

	@OneToMany
	private List<ServiceModel> availableServiceList;
	@OneToMany
	private List<Image> images;
	private String description;

	public int getTravelPackageId() {
		return travelPackageId;
	}

	public void setTravelPackageId(int travelPackageId) {
		this.travelPackageId = travelPackageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<ServiceModel> getAvailableServiceList() {
		return availableServiceList;
	}

	public void setAvailableServiceList(List<ServiceModel> availableServiceList) {
		this.availableServiceList = availableServiceList;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
