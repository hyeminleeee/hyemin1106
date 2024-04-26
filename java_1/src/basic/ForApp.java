package basic;

public class ForApp {
	public static void main(String[] args) {
		for(int i=1 ; i <= 5 ; i++) {
			System.out.println("Java Programming");
		}
		System.out.println("========================================================");
		
		//1~100범위의 정수들의 합계 계산하여 출력
		//=> 1+2+3+4+.....98+99+100=?
		int tot=0;
		for(int i=1 ; i<=100; i++) {
			tot+=i;
		}
		System.out.println("1~100범위 정수들의 합계 = "+tot);
		System.out.println("========================================================");
		
		//두 변수에 저장된 정수값에 대한 범위의 합계를 계산하여 출력
		int begin=20, end=80;
		
		/* 시작값이 종료값보다 큰 경우 에러메세지 출력 후 강제 종료
		 * if(begin > end) {
			System.out.println("[Error]시작값이 종료값보다 작아야 합니다.");
			System.exit(0);
		}
		*/
		//시작값이 종료값보다 큰 경우 두 변수에 저장된 값을 서로 바꾸어 저장 처리
		if(begin > end) {
			//두 변수에 저장된 값을 서로 바꾸어 저장하는 명령 - 치환 알고리즘
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
			
		}
		System.out.println(begin+"~"+end+"범위 정수들의 합계 = "+sum);
		System.out.println("========================================================");
		
	}

}
