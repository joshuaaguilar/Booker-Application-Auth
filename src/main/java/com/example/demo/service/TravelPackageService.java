package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.ServiceModel;
import com.example.demo.model.Travelpackage;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ImageRepository imageRepository;

	private ServiceRepository serviceRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository, ImageRepository imageRepository,
			ServiceRepository serviceRepository) {
		this.travelPackageRepository = travelPackageRepository;
		this.imageRepository = imageRepository;
		this.serviceRepository = serviceRepository;
	}

	public Travelpackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public Travelpackage save(Travelpackage travelpackage) {
		travelPackageRepository.save(travelpackage);
		for (Image image : travelpackage.getImages()) {
			image.setTravelPackage(travelpackage);
			imageRepository.save(image);
		}
		for (ServiceModel servicemodel : travelpackage.getAvailableServiceList()) {
			servicemodel.setTravelpackage(travelpackage);
			serviceRepository.save(servicemodel);
		}
		return travelpackage;
	}

	public void delete(int id) {
		travelPackageRepository.deleteById(id);
	}

	public List<Travelpackage> findAll() {
		return (List<Travelpackage>) travelPackageRepository.findAll();

	}

	public List<Travelpackage> saveList(List<Travelpackage> travelPackageList) {
		for (Travelpackage tp : travelPackageList) {
			save(tp);
		}
		return (List<Travelpackage>) travelPackageRepository.findAll();
	}

	public void deleteList(int[] travelPackageList) {
		for (int id : travelPackageList) {
			travelPackageRepository.deleteById(id);
		}
	}

	// public List<Travelpackage> findTravelPackageList(int[] travelids){
//		for(int id:travelids) {
//			Travelpackage newtravelpackage=travelPackageRepository.findById(id).get();

//		}
//	}

}
