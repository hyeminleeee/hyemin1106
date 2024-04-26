package basic;

public class WhileApp {
	public static void main(String[] args) {
		int i=1;
		while(i<-5) {
			System.out.println("Java Programming");
			i++;			
		}
		System.out.println("=========================================");
		
		//1~100범위의 정수들의 합계 계산하여 출력
		int j=1, tot=0;
		do {
			tot+=j;
			j++;
		} while(j<=100);
		
		System.out.println("1~100범위 정수들의 합계 = "+tot);
		System.out.println("=========================================");
		
		//A4용지를 반으로 계속 접어 펼쳤을 때 사각형 갯수가 500개 이상이 되려면 몇 번 접어야할까?
		int cnt=0, gae=1;
		
		//사각형 모양의 갯수가 500개 미만인 경우 접는 행위를 반복 실행
		//사각형 모양의 갯수가 500개 이상인 경우 반복문 종료
		while(gae<500) {
			cnt++;//접는 횟수는 1씩 증가되도록 연산 처리
			gae*=2;//사각형 모양의 갯수는 2배씩 증가되도록 연산 처리
		}
		System.out.println("[결과]"+cnt+"번 접으면"+gae+"개의 사각형이 만들어진다.");		
		System.out.println("=========================================");
		
		//1~x 범위의 정수들의 합계가 300 이상이 만들어지려면 x가 얼마인지 계산.
		
		int x=0, sum=0;//x: 1씩 증가되는 값, sum: 합계 저장
		
		while (sum<300) {
			x++;
			sum+=x;
		}
		System.out.println("1~"+x+"범위의 정수들의 합계 = "+sum);	
		System.out.println("=========================================");
	}
}
