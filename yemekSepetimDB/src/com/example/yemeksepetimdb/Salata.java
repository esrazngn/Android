package com.example.yemeksepetimdb;

public class Salata 
{
	private String ad;
	private int fiyat;
	public Salata(String ad, int fiyat) 
	{
		super();
		this.ad = ad;
		this.fiyat = fiyat;
	}
	
	public Salata() 
	{
		// TODO Auto-generated constructor stub
	}

	public int getFiyat() 
	{
		return fiyat;
	}
	public void setFiyat(int fiyat) 
	{
		this.fiyat = fiyat;
	}
	public String getAd() 
	{
		return ad;
	}
	public void setAd(String ad) 
	{
		this.ad = ad;
	}
	
	
	@Override
	public String toString() 
	{
		return "Salata  [ad = " + ad + ", fiyat = " + fiyat  + "]";
	}
	
		    
}
	
