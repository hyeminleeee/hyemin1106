package xyz.itwill.thread;

public class SingleThread {
	public void disPlay() {
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작");

		for(char i='a'; i<='z'; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		System.out.println("SingleThreadApp 클래스의 main() 메소드 종료");

	}
}
