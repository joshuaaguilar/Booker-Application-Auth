package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ServiceModel;
import com.example.demo.model.Travelpackage;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.repository.TravelPackageServiceRepository;

@Service
public class TravelPackageServiceService {

	private TravelPackageServiceRepository travelPackageServiceRepository;
	private TravelPackageRepository travelPackageRepository;

	public TravelPackageServiceService(TravelPackageServiceRepository travelPackageServiceRepository,
			TravelPackageRepository travelPackageRepository) {
		this.travelPackageServiceRepository = travelPackageServiceRepository;
		this.travelPackageRepository = travelPackageRepository;
	}

	public ServiceModel findbyid(int packageid, int serviceid) {
		ServiceModel servicemodelreturn = null;
		Travelpackage travelpackage = travelPackageRepository.findById(packageid).get();
		for (ServiceModel servicemodel : travelpackage.getAvailableServiceList()) {
			if (servicemodel.getServiceId() == serviceid) {
				servicemodelreturn = servicemodel;
			}

		}
		return servicemodelreturn;

	}

	public ServiceModel save(ServiceModel servicemodel) {
		return travelPackageServiceRepository.save(servicemodel);

	}

	public List<ServiceModel> delete(ServiceModel serviceModel, int packageid) {
		travelPackageServiceRepository.delete(serviceModel);
		Travelpackage travelpackage = travelPackageRepository.findById(packageid).get();
		return travelpackage.getAvailableServiceList();
	}
}
