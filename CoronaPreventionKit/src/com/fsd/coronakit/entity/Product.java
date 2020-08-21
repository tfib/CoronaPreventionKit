package com.fsd.coronakit.entity;

public class Product {

	private int productId;
	private String pName;
	private double pcost;
	private String pDescription;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPcost() {
		return pcost;
	}

	public void setPcost(double pcost) {
		this.pcost = pcost;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return productId+" "+pName+" "+pcost+" "+pDescription;
	}

	
}
