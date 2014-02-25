package com.example.yemeksepetimdb;



public class Kullanici 
{
		
	private String kullaniciAd;
	private String sifre;
	private String yetki;
		   

		    public Kullanici (String kullaniciAd, String sifre, String yetki) 
		    {
		            super();
		            this.kullaniciAd = kullaniciAd;
		            this.sifre = sifre;
		            this.yetki = yetki;
		    }
		    
		    public Kullanici() {
				// TODO Auto-generated constructor stub
			}

			public String getKullaniciAd() 
		    {
		            return kullaniciAd;
		    }
			
		    public void setKullaniciAd(String kullaniciAd) 
		    {
		            this.kullaniciAd = kullaniciAd;
		    }
		    public String getSifre() 
		    {
		            return sifre;
		    }
		    public void setSifre(String sifre) 
		    {
		            this.sifre = sifre;
		    }
		    public String getYetki() 
		    {
		            return yetki;
		    }
		   
		    
		    @Override
		    public String toString() 
		    {
		            return "Kullanic [kullaniciAd =" + kullaniciAd + ", sifre =" + sifre + "yetki = " + yetki + "]";
		    }

			public void setYetki(String yetki) {
				 this.yetki = yetki;
				
			}
		    
		    
	}


