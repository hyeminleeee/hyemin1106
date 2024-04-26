package example;

public class ForExample {
	public static void main(String[] args) {
		//본인 이름을 화면에 7번 출력하세요.
		//ex) 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동
		for(int i=1;i<=7;i++) {
			System.out.print("이혜민 ");
		}
		System.out.println();
		System.out.println("=========================================");
		
		//1~10 범위의 정수 중 홀수를 화면에 출력하세요.
		//ex) 1     3     5     7     9
		for(int i=1;i<=10;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("=========================================");
		
		//for(int i=1;i<=9;i++) {
			//if(i)
	//}
		
		//1~100 범위의 정수에서 3의 배수들의 합계와 5의 배수들의 합계를 계산하여
		//3의 배수의 합계에서 5의 배수의 합계를 뺀 결과값을 출력하세요.
		//ex) 결과 = 633
		int sam=0, oh=0;
		for(int i=3; i<=100; i+=3) {
			sam+=i;
		}
		System.out.println("3의 배수들의 합계 = "+sam);
		
		for(int i=5;i<=100;i+=5) {
			oh+=i;
		}
		System.out.println("5의 배수들의 합계 ="+oh);
		int result=sam-=oh;
		System.out.println("결과 = "+result);
		
		System.out.println("=========================================");
		/*int tot3=0, tot5=0;
		for(int i=1; i<=100; i++) {
			if(i%3==0) tot3+=i;
			if(i%5==0) tot5+=i;
		}
		System.out.println("결과 = "+(tot3-tot5));
		System.out.println("=========================================");
		*/
		//구구단 중 7단을 화면에 출력하세요.
		//ex) 7 * 1 = 7
		//    7 * 2 = 14
		//    ...
		//    7 * 8 = 56
		//    7 * 9 = 63
		int x=7, i=1;
		for(i=1;i<=9;i++) {
			System.out.println(x+" * "+i+" = "+(x*i));
		}
		//중첩 for문을 쓰지 않고 println을 써서 하나씩 내렸음.
		System.out.println("=========================================");
		
		//5!의 결과값을 출력하세요.(5! = 5 * 4 * 3 * 2 * 1)
		//ex) 5! = 120
		int sum=1, num=5;
		for(i=num;i>=1;i--) {
			sum *= i;
		}
		System.out.println("5! = "+sum);
		System.out.println("=========================================");
		
		//두 변수에 저장된 범위의 정수값을 화면에 출력하세요.
		//단, 한 줄에 정수값이 7개씩 출력되도록 프로그램을 작성하세요.
		//ex) 36    37    38     39     40     41     42
		//    43    44    45     46     47     48     49
		//    50    51    52     53     54     55     56
		//    57
		int begin=36, end=57;
		/*int cnt=0;
		for(;begin<=end;begin++) {
			if(cnt == 7) {
				System.out.println();
				cnt=0;
			}
			cnt++;
			System.out.print(begin+"\t");
		}
		
		System.out.println();
		System.out.println("=========================================");
		*/
		int cnt=0;
		for(int j = begin; j<=end; j++) {
			System.out.print(j+"\t");
			cnt++;
			if(cnt % 7 == 0) {
				System.out.println();
			}
		}

	}
}