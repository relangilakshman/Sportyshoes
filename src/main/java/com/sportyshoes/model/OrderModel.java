package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Component
@Entity
public class OrderModel {@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	private String orderType;
	private String productName;
	private int noOfProducts;
	private double eachProdCost;
	private double totalCost;
	
	
	private int modelNo;
	private String creationDt;	
	private String ordertStatus;
	
	//private String encodeImage;
	
	private String userName;
	private String dispatchAddress;
	private String userEamil;
	private String dispatchDt;
	private String userPhno;
	
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public double getEachProdCost() {
		return eachProdCost;
	}
	public void setEachProdCost(double eachProdCost) {
		this.eachProdCost = eachProdCost;
	}
	
	public int getModelNo() {
		return modelNo;
	}
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	public String getCreationDt() {
		return creationDt;
	}
	public void setCreationDt(String creationDt) {
		this.creationDt = creationDt;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrdertStatus() {
		return ordertStatus;
	}
	public void setOrdertStatus(String ordertStatus) {
		this.ordertStatus = ordertStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDispatchAddress() {
		return dispatchAddress;
	}
	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}
	public String getUserEamil() {
		return userEamil;
	}
	public void setUserEamil(String userEamil) {
		this.userEamil = userEamil;
	}
	public String getDispatchDt() {
		return dispatchDt;
	}
	public void setDispatchDt(String dispatchDt) {
		this.dispatchDt = dispatchDt;
	}
	public String getUserPhno() {
		return userPhno;
	}
	public void setUserPhno(String userPhno) {
		this.userPhno = userPhno;
	}
	
	
	
	}
