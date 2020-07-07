package edu.csuft.Bruno.world.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dept implements Serializable {

	int id;
	
	String name;
	
	String city;
	
	List<Staff> staffList = new ArrayList<>();
	
	public Dept() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
	
	
}
