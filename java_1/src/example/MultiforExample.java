package example;

public class MultiforExample {
	public static void main(String[] args) {
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i-1;j++) {
				System.out.print("☆");
			}
			for(int j=1;j<=6-i;j++) {
				System.out.print("★");			
			}
			System.out.println();
		}
		
		System.out.println("===============================================================");
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(j<i) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("===============================================================");
		//☆☆☆☆★ - 4/1
		//☆☆☆★★★ -3/3
		//☆☆★★★★★ -2/5
 		//☆★★★★★★★ - 1/7
		//★★★★★★★★★ - 0/9
		
 		int cnt=0;
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("☆");
			}
			for(int j=1;j<=i+cnt;j++) {
				System.out.print("★");
			}
			cnt++;
			System.out.println();
			
		}
		System.out.println();	
		System.out.println("===============================================================");
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print("☆");
			}
			for(int j=1; j<=i*2-1;j++) {
				System.out.print("★");
			}
			System.out.println();
				
		}
		System.out.println();	
		System.out.println("===============================================================");
		
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★
		
		System.out.println("===============================================================");
	}
}