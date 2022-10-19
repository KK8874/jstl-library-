package com.infinite.hib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Agent")
public class Agent {
	@Id
	@Column(name="agentId")
	private int agentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="city")
	private String city;
	
	@Column(name="maritalStatus")
	private String maritalStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="premium")
	private Double premium;
	
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
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
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Double getPremium() {
		return premium;
	}
	public void setPremium (Double premium) {
		this.premium =premium;
	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", name=" + name + ", city=" + city + ", maritalStatus=" + maritalStatus
				+ ", gender=" + gender + ", premium=" + premium + "]";
	}
	

}
