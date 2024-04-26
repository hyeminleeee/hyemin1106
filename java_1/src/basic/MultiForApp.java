package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int count=0;//이동방법의 갯수 저장 변수
		
		for(int i=1;i<=3;i++) {//[가]나라 > 섬 - 3번 반복
			for(int j=1;j<=4;j++) {//[가]나라 > 섬 - 4번 반복
				count++;				
			}
			
		}
		
		System.out.println("이동방법의 갯수 = "+count);
		System.out.println("=================================================================");
		
		//★
		System.out.println("★");
		System.out.println("=================================================================");
		
		for(int j=1;j<=4;j++) {//행(Row)을 처리하기 위한 반복문
			for(int i=1;i<=5;i++) {//열(Cloumn)을 처리하기 위한 반복문
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");
		
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		//★★★★★★★★
		for(int j=1;j<=9;j++) {//행(Row)을 처리하기 위한 반복문
			for(int i=2;i<=9;i++) {//열(Cloumn)을 처리하기 위한 반복문
				System.out.print(i+"*=\t");
			}
			System.out.println();	
		}
		System.out.println("=================================================================");
		
		for(int j=1;j<=9;j++) {//행(Row)을 처리하기 위한 반복문
			for(int i=2;i<=9;i++) {//열(Cloumn)을 처리하기 위한 반복문
				System.out.print(i+"*"+j+"=\t");
			}
			System.out.println();	
		}
		System.out.println("=================================================================");
		
		for(int j=1;j<=9;j++) {//행(Row)을 처리하기 위한 반복문
			for(int i=2;i<=9;i++) {//열(Cloumn)을 처리하기 위한 반복문
				System.out.print(i+"*"+j+"="+(j*i)+"\t");
			}
			System.out.println();	
		}
		System.out.println("=================================================================");
		
		//★
		//★★
		//★★★
		//★★★★
		//★★★★★
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");
		
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=6-i;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		System.out.println("=================================================================");
		
		//☆☆☆☆★
		//☆☆☆★★
		//☆☆★★★
		//☆★★★★
		//★★★★★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5-i;j++) {
				System.out.print("☆");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("★");
			}
			System.out.println();	

		}
		System.out.println("=================================================================");
		
		//☆☆☆☆★
		//☆☆☆★★
		//☆☆★★★
		//☆★★★★
		//★★★★★
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(i + j < 6) {
					System.out.print("☆");
				} else {
					System.out.print("★");
				}
			}
			System.out.println();	
		}
		System.out.println("=================================================================");		
	}

}
