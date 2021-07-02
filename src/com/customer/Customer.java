package com.customer;

import java.util.Date;

public class Customer {
	private String name;
	private String address;
	private String phoneNumber;
	private Date bookingDate;
	private Date deliveryDate;
	private String type;
	
	private double height;
	private double chest;
	private double stomach;
	private double seat;
	private double bicep;
	private double frontChest;
	private double frontStomach;
	private double frontSeat;
	private double kataHeight;
	private double waist;
	private double mandi;
	private double standCollar;
	private double underline;
	private double elbow;
	private double caugh;
	private double bottom;
	private double collar;
	private double handLength;
	private double sholder;
	
	public double getUnderline() {
		return underline;
	}

	public void setUnderline(double underline) {
		this.underline = underline;
	}

	public double getElbow() {
		return elbow;
	}

	public void setElbow(double elbow) {
		this.elbow = elbow;
	}

	public double getCaugh() {
		return caugh;
	}

	public void setCaugh(double caugh) {
		this.caugh = caugh;
	}

	public double getBottom() {
		return bottom;
	}

	public void setBottom(double bottom) {
		this.bottom = bottom;
	}

	public double getCollar() {
		return collar;
	}

	public void setCollar(double collar) {
		this.collar = collar;
	}

	public double getHandLength() {
		return handLength;
	}

	public void setHandLength(double handLength) {
		this.handLength = handLength;
	}

	public double getSholder() {
		return sholder;
	}

	public void setSholder(double sholder) {
		this.sholder = sholder;
	}

	private double other;
	

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getChest() {
		return chest;
	}

	public void setChest(double chest) {
		this.chest = chest;
	}

	public double getStomach() {
		return stomach;
	}

	public void setStomach(double stomach) {
		this.stomach = stomach;
	}

	public double getSeat() {
		return seat;
	}

	public void setSeat(double seat) {
		this.seat = seat;
	}

	public double getBicep() {
		return bicep;
	}

	public void setBicep(double bicep) {
		this.bicep = bicep;
	}

	public double getFrontChest() {
		return frontChest;
	}

	public void setFrontChest(double frontChest) {
		this.frontChest = frontChest;
	}

	public double getFrontStomach() {
		return frontStomach;
	}

	public void setFrontStomach(double frontStomach) {
		this.frontStomach = frontStomach;
	}

	public double getFrontSeat() {
		return frontSeat;
	}

	public void setFrontSeat(double frontSeat) {
		this.frontSeat = frontSeat;
	}

	public double getKataHeight() {
		return kataHeight;
	}

	public void setKataHeight(double kataHeight) {
		this.kataHeight = kataHeight;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double waist) {
		this.waist = waist;
	}

	public double getMandi() {
		return mandi;
	}

	public void setMandi(double mandi) {
		this.mandi = mandi;
	}

	public double getStandCollar() {
		return standCollar;
	}

	public void setStandCollar(double standCollar) {
		this.standCollar = standCollar;
	}

	public double getOther() {
		return other;
	}

	public void setOther(double other) {
		this.other = other;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}

}
