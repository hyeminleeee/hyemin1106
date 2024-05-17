package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//프레임의 [닫기] 버튼을 누른 경우 프로그램을 종료하는 이벤트 처리 프로그램
//=> 프레임(Frame 객체)에서는 WindowEvent 발생되므로 WindowAdapter 클래스를 상속받은
//자식클래스를 작성하여 이벤트 처리 클래스로 사용
public class WindowAdapterApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	public WindowAdapterApp(String title) {
		super(title);
		
		//addWindowListener(new WindowEventHandle());
		
		//추상클래스(Adapter 클래스)를 상속받은 익명의 자식클래스로 객체를 생성하여 이벤트 처리 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(800, 200, 300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowAdapterApp("WindowEvent");
	}
	
	//Adapter 클래스를 상속받은 자식클래스(이벤트 처리 클래스)는 Adapter 클래스의 메소드를
	//필요한 경우에만 오버라이딩 선언
	//Adapter 클래스 : Listener 인터페이스에 추상메소드가 2개 이상 작성된 Listener 인터페이스
	//대신 이벤트를 처리하기 위한 메소드를 제공하는 클래스
	public class WindowEventHandle extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}