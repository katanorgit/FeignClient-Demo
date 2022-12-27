package com.rkatanor.feignclientdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ID")
	private int id;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_TYPE")
	private String productType;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String product_desc;

	@Column(name = "PRODUCT_PRICE")
	private double product_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productType=" + productType + ", product_desc="
				+ product_desc + ", product_price=" + product_price + "]";
	}

}
