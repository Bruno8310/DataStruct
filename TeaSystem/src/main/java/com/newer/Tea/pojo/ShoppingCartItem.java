package com.newer.Tea.pojo;

public class ShoppingCartItem {
	
	int cartItemId;
	
	String phone;
	
	int goodsId;
	
	String goodsName;
	
	String others;
	
	String size;
	
	String suger;
	
	String temp;
	
	int number;
	
	int isPay;
	
	int price;
	
	public ShoppingCartItem() {
		
	}
	
	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSuger() {
		return suger;
	}
	public void setSuger(String suger) {
		this.suger = suger;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int isPay() {
		return isPay;
	}
	public void setPay(int isPay) {
		this.isPay = isPay;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [cartItemId=" + cartItemId + ", phone=" + phone + ", goodsId=" + goodsId
				+ ", goodsName=" + goodsName + ", others=" + others + ", size=" + size + ", suger=" + suger + ", temp="
				+ temp + ", number=" + number + ", isPay=" + isPay + ", price=" + price + "]";
	}
	
	

}
