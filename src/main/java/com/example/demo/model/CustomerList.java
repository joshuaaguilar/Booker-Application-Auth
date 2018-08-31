package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CustomerList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerIdList;
	@OneToMany
	private List<Customer> customerlist;

	public CustomerList() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerIdList() {
		return customerIdList;
	}

	public void setCustomerIdList(int customerList) {
		this.customerIdList = customerList;
	}

	public List<Customer> getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(List<Customer> customerlist) {
		this.customerlist = customerlist;
	}

}
