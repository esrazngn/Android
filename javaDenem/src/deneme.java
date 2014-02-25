
public class deneme {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x, y, z, m, t, n;
		 
        x=10; 
        y=5;
        z=16;
 
        m = ++x - --y + ++z; // 11 - 4 + 17 = 24 ++a olduðunda arttýrýp kullanýr
        
        //t = x++ - y-- + z++; // 10 - 5 + 16 = 21  a++ olduðunda kullanýr sonra deðeri arttýrýlýr. Yani arttýrýlmadan kullanýlýr.
 
        
      //  System.out.println("t="+t);
        System.out.println("z="+z);
        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println("m="+m);

	}

}
