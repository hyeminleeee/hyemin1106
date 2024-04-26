package basic;

public class BreakApp {
	public static void main(String[] args) {
		//반복문의 조건식이 거짓인 경우 반복문 종료.
		for(int i=1;i<=5;i++) {
			//if 구문의 조건식이 참인 경우 break 명령이 실행되어 반복문 종료
			if(i == 3) break;
			System.out.println("i = "+i);
		}
		System.out.println("==========================================");
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//break 명령을 실행하면 break 명령이 포함된 반복문만 종료
				if(j==3) break;
				System.out.println("i = "+i+", j = "+j);
			}
		}
	}
}
