/*
 * package com.example.demo.model;
 * 
 * import java.security.Timestamp; import java.util.List;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToMany;
 * 
 * @Entity public class Reservation {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int
 * reservationId;
 * 
 * @OneToMany private List<Service> availedServiceList;
 * 
 * public List<Service> getAvailedServiceList() { return availedServiceList; }
 * 
 * public void setAvailedServiceList(List<Service> availedServiceList) {
 * this.availedServiceList = availedServiceList; }
 * 
 * public Timestamp getDepartureDate() { return departureDate; }
 * 
 * public void setDepartureDate(Timestamp departureDate) { this.departureDate =
 * departureDate; }
 * 
 * public Customer getCustomer() { return customer; }
 * 
 * public void setCustomer(Customer customer) { this.customer = customer; }
 * 
 * private Timestamp departureDate; private Customer customer;
 * 
 * public int getReservationId() { return reservationId; }
 * 
 * public void setReservationId(int reservationId) { this.reservationId =
 * reservationId; }
 * 
 * public Reservation() { // TODO Auto-generated constructor stub }
 * 
 * }
 */