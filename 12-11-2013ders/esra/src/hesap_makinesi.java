import java.util.Scanner;


public class hesap_makinesi {
	
    int sayi1,sayi2,toplam,carpim,bolum,fark,islem;
    Scanner scan;
	
	public void kullanicidanAl(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("işlem yapmak istediğiniz ilk sayiyi giriniz:\n");
		sayi1 = scan.nextInt();
		
		System.out.println("işlem yapmak istediğiniz ilk sayiyi giriniz:\n");
		sayi2 = scan.nextInt();
		
	}
	
	public void toplamaIslemi(){
		
		toplam = sayi1 + sayi2;	
		System.out.println("toplama işleminin sonucu:"+toplam);
	}
	
	public void carpmaIslemi(){
		
		carpim = sayi1 * sayi2;	
		System.out.println("çarpma işleminin sonucu:"+carpim);
	}
	
	public void cikarmaIslemi(){
		
		fark = sayi1 - sayi2;
		System.out.println("çıkarma işleminin sonucu:"+fark);
	}
	
	public void bolmeIslemi(){
		
		bolum = sayi1 / sayi2;	
		System.out.println("bölme işleminin sonucu:"+bolum);
	}
	public void kontrolEt(){
		
			if(sayi2==0){
				System.out.println ("Sıfıra bölme hatası lütfen başka bir değer giriniz!!");
				kullanicidanAl();
				kontrolEt();
				
				}
			
			islemSec();
	}
	public void islemSec(){
		Scanner scan = new Scanner(System.in);
		System.out.println("toplama için 1,çıkarma için 2, çarpma için 3, bölme için 4 ü seçiniz:\n");
		islem = scan.nextInt();
	
		switch(islem){
		
		case(1):
			toplamaIslemi();
			break;
	
		case(2):
			cikarmaIslemi();
			break;
		case(3):
			carpmaIslemi();
			break;
		case(4):
			bolmeIslemi();
			break;
		}
		
	}
	public void ekranaYaz(){
		
		System.out.println("birinci sayı:"+sayi1);
		System.out.println("ikinci sayı:"+sayi2);
	}
	public static void main(String args[]){
		
		hesap_makinesi A = new hesap_makinesi();
		A.kullanicidanAl();
		A.ekranaYaz();
		A.kontrolEt();
	}
}