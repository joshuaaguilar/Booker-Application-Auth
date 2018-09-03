package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServiceModel;
import com.example.demo.model.Travelpackage;
import com.example.demo.service.TravelPackageService;
import com.example.demo.service.TravelPackageServiceService;

@RestController
@RequestMapping("/travel-packages")
public class TravelPackageController {
	private TravelPackageServiceService travelPackageServiceService;
	private TravelPackageService travelPackageService;

	public TravelPackageController(TravelPackageService travelPackageService,
			TravelPackageServiceService travelPackageServiceService) {
		this.travelPackageService = travelPackageService;
		this.travelPackageServiceService = travelPackageServiceService;
	}

	@GetMapping("/{travelPackgeId}/services")
	public List<ServiceModel> findAllservices(@RequestHeader String token, @PathVariable("travelPackgeId") int id) {
		return travelPackageServiceService.findAll(id);
	}

	@PostMapping("/{travelPackgeId}/services")
	public List<ServiceModel> saveList(@RequestHeader String token, @PathVariable("travelPackgeId") int id,
			@RequestBody List<ServiceModel> serviceList) {
		return travelPackageServiceService.saveList(id, serviceList);
	}

	@DeleteMapping("/{travelPackgeId}/services")
	public void deleteServices(@RequestHeader String token, @PathVariable("travelPackgeId") int id) {
		travelPackageServiceService.deleteAllServicesbyTravelPackageId(id);
	}

	@GetMapping("/{travelPackageId}")
	public Travelpackage findById(@RequestHeader String token, @PathVariable("travelPackageId") int id) {
		return travelPackageService.findById(id);
	}

	@PutMapping("/{travelPackageId}")
	public Travelpackage update(@RequestHeader String token, @PathVariable("travelPackageId") int id,
			@RequestBody Travelpackage travelpackage) {
		travelpackage.setTravelPackageId(id);
		travelPackageService.save(travelpackage);
		return travelpackage;
	}

	@DeleteMapping("/{travelPackageId}")
	public void delete(@RequestHeader String token, @PathVariable("travelPackageid") int id) {
		travelPackageService.delete(id);

	}

	@GetMapping
	public List<Travelpackage> findAll(@RequestHeader String token) {
		return travelPackageService.findAll();
	}

	@PostMapping
	@Transactional
	public List<Travelpackage> saveList(@RequestHeader String token, @RequestBody List<Travelpackage> travelpackages) {
		return travelPackageService.saveList(travelpackages);
	}

	@DeleteMapping
	public void deleteList(@RequestHeader String token, @RequestParam("travelPackageId") int[] ids) {
		travelPackageService.deleteList(ids);
	}

//	@PutMapping
//	public List<Travelpackage> updateList(@RequestBody List<Travelpackage> travelpackages){
//		travelPackageService.
//	}

	@GetMapping("/{travelPackageId}/services/{serviceId}")
	public ServiceModel findById(@RequestHeader String token, @PathVariable("travelPackageid") int travelid,
			@PathVariable("serviceId") int serviceid) {
		return travelPackageServiceService.findbyid(travelid, serviceid);
	}

//	@PutMapping("/{travelPackageId}/services/{serviceId}")
//	public ServiceModel update(@PathVariable("travelPackageid") int travelid, @PathVariable("serviceId") int serviceid,
//			@RequestBody ServiceModel servicemodel) {
//		servicemodel.setServiceId(travelPackageServiceService.findbyid(travelid, serviceid).getServiceId());
//		return travelPackageServiceService.save(servicemodel);
//	}

	@DeleteMapping("/{travelPackageId}/services/{serviceId}")
	public List<ServiceModel> delete(@RequestHeader String token, @PathVariable("travelPackageId") int travelid,
			@PathVariable("serviceId") int serviceid) {
		return travelPackageServiceService.delete(travelPackageServiceService.findbyid(travelid, serviceid), travelid);

	}

}
