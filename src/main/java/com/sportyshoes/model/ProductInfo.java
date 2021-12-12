package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ProductInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productType;
	private String productName;
	private int noOfProducts;
	private double eachProdCost;
	
	@Lob
	private byte[] image;
	private int modelNo;
	private String creationDt;	
	private String productStatus;
	
	private String encodeImage;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
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
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getEncodeImage() {
		return encodeImage;
	}
	public void setEncodeImage(String encodeImage) {
		this.encodeImage = encodeImage;
	}
	
	
	
	

}
