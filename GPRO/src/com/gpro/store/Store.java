package com.gpro.store;

public class Store {
//	GOOD_NUM      NUMBER         
//	GOOD_NAME     VARCHAR2(4000) 
//	GOOD_PRICE    NUMBER         
//	EVENT_MAIN       VARCHAR2(4000) 

	private int goodNum;
	private String goodName;
	private String goodPrice;
	private String eventMain;

	public Store() {
		// TODO Auto-generated constructor stub
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getEventMain() {
		return eventMain;
	}

	public void setEventMain(String eventMain) {
		this.eventMain = eventMain;
	}

	@Override
	public String toString() {
		return "Store [goodNum=" + goodNum + ", goodName=" + goodName + ", goodPrice=" + goodPrice + ", eventMain="
				+ eventMain + "]";
	}

}
