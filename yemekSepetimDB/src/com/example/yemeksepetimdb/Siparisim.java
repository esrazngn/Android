package com.example.yemeksepetimdb;

import java.util.Date;

public class Siparisim 
{
	private int siparisID;
	private String yemekler, icecekler, salatalar, date, fiyat;
	
	public Siparisim(int siparisID, String yemekler, String icecekler, String salatalar, String fiyat, String date) 
	{
		 super();
		 this.siparisID = siparisID;
		 this.yemekler = yemekler;
		 this.icecekler = icecekler;
		 this.salatalar = salatalar;
		 this.date = date;
		 this.fiyat = fiyat;
	 }
	 
	 public Siparisim() 
	 {
		 // TODO Auto-generated constructor stub
	 }
	 
	 public int getSiparisID()
	 {
		 return siparisID;
	 }
	 
	 public void setSiparisID(int siparisID)
	 {
		 this.siparisID = siparisID;
	 }
	 
	 public String getYemekler()
	 {
		 return yemekler;
	 }
	 
	 public void setYemekler(String yemekler)
	 {
		 this.yemekler = yemekler;
	 }
	 
	 public String getSalata()
	 {
		 return salatalar;
	 }
	 
	 public void setSalatalar(String salatalar)
	 {
		 this.salatalar = salatalar;
	 }
	 
	 public String getIcecekler()
	 {
		 return icecekler;
	 }
	 
	 public void setIcecekler(String icecekler)
	 {
		 this.icecekler = icecekler;
	 }
	 
	 public String getFiyat() 
	 {
		 return fiyat;
	 }
	 public void setFiyat(String fiyat) 
	 {
		 this.fiyat = fiyat;
	 }
	 
	 public String getDate()
	 {
		 return date;
	 }
	 
	 public void setDate(String date)
	 {
		 this.date = date;
	 }
	 
	 @Override
	 public String toString() 
	 {
		 return "Icecek [siparisID = " + siparisID + ", yemekler = " + yemekler +", icecekler = "+ icecekler 
				 +", salatalar = "+salatalar +", fiyat = " + fiyat + ", date = " + date + "]";
	 }
}
