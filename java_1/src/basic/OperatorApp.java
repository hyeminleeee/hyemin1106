package basic;

public class OperatorApp {
	public static void main(String[] args) {
		System.out.println("10 + 20 * 3 ="+(10+20*3));
		System.out.println("(10 + 20) * 3 ="+((10+20)*3));
		System.out.println("===================================================");
		
		
		int a1=10;
		System.out.println("a1 = "+a1);
		System.out.println("-a1 = "+(-a1));
		System.out.println("===================================================");
		
		System.out.println("20 > 10 ="+(20>10));
		System.out.println("20 > 10 ="+!(20>10));
		System.out.println("===================================================");
		
		int a2=10, a3=10;
		System.out.println("a2 ="+a2+", a3 = "+a3);
		
		++a2;
		--a3;
		System.out.println("a2 ="+a2+", a3 = "+a3);
		System.out.println("===================================================");
		
		int c1=20, c2=10;
		System.out.println(c1+" * "+c2+" = "+(c1*c2));
		System.out.println(c1+" / "+c2+" = "+(c1/c2));
		System.out.println(c1+" % "+c2+" = "+(c1%c2));
		System.out.println(c1+" + "+c2+" = "+(c1+c2));
		System.out.println(c1+" - "+c2+" = "+(c1-c2));
		System.out.println("===================================================");
		
		
		//int e1=20, e2=10;
		int e1=10, e2=20;
		
		System.out.println("큰 값 ="+(e1 > e2 ? e1 : e2));
		System.out.println("===================================================");
		
		
	}

}
