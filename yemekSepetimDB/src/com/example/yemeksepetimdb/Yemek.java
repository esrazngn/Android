package com.example.yemeksepetimdb;

public class Yemek 
{
	
	    private String ad;
	    private int fiyat;
	   

	    public Yemek(String ad, int fiyat) 
	    {
	            super();
	            this.ad = ad;
	            this.fiyat = fiyat;
	    }
	    
	    public Yemek() {
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
	            return "Yemek [ad=" + ad + ", fiyat =" + fiyat  + "]";
	    }
	    
	    
	}

