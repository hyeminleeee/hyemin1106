package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드로 원시데이터로 입력받아 파일에 전달하여 저장하는 프로그램 작성
//=> EOF(End Of File) 신호(Ctrl+Z - 입력 종료)를 받기 전으면 프로그램 종료

public class FileOutputStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");
		
		//FileOutputStream 클래스 : 파일에 원시데이터를 전달하여 저장할 수 있는 출력스트림을
		//생성하기 위한 클래스
		//=> FileOutputStream(String name) 생성자를 사용하여 FileOutputStream 객체 생성
		//=> name 매개변수에는 출력스트림을 생성하기 위한 파일의 경로를 전달하여 저장
		//=> name 매개변수로 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생
		//=> 파일 출력스트림을 생성할 때 매개변수로 전달받은 파일이 없는 경우 자동으로 파일을
		//생성해 파일 출력스트림을 제공하므로 FileNotFoundException은 예외 처리하지 않고 전달
		//=> name 매개변수로 전달받은 파일이 있는 경우 기존 파일내용을 초기화하고 새로운 내용으로 
		//저장되도록 처리
		//FileOutputStream out=new FileOutputStream("c:/data/byte.txt");
		//매개변수로 전달받은 경로에 파일이 없으면 새로운 파일을 만들어서 스트림을 만들어준다.
		//예외처리 할 필요가 없다.
		
		//=> FileOutputStream(String name, boolean append) 생성자를 사용하여 FileOutputStream 객체 생성
		//=> append 매개변수에 [true]를 전달할 경우 name 매개변수로 전달받은 파일이 있으면 기존 내용에
		//새로운 내용을 추가하여 저장되도록 처리
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt", true);//통로
		
		
		
		int readByte;
		while(true) {
			////키보드 입력스트림으로 원시데이터를 반환받아 변수에 저장
			//=> FileNotFoundException 클래스는 IOException 클래스의 자식클래스이므로
			//FileNotFoundException 클래스 대신 IOException 클래스로 예외처리 가능
			readByte=System.in.read();
			//입력스트림에 있는 원시데이터를 하나하나(1byte 씩) 읽어서 변수에 저장하는 read() 메소드
			
			if(readByte==-1) break;
			
			//파일 출력스트림으로 원시데이터를 전달하여 저장- Save
			out.write(readByte);
			//out = FileOutputStream 객체가 저장되어 있음 (파일 출력스트림)
			//write 1byte씩 내보내는 것(while 문으로 계속 반복 / -1신호를 받기전까지
			//변수에 있는 원시데이터를 파일 출력스트림에 보낸다
		}
		
		//FileOutputStream.close() : 파일 출력스트림을 제거하는 메소드
		//=> 파일에는 입력스트림과 출력스트림을 각각 하나씩만 생성하여 사용 가능하므로
		//입력스트림을 또는 출력스트림을 사용한 후에는 반드시 제거
		out.close();
		//제거하는 이유 : 파일에는 입력스트림, 출력스트림을 하나씩밖에 못만든다.
		//필요할 때 파일 스트림을 만들어서 입출력할 수 있다. 
		
		System.out.println("[결과]c:\\data\\byte.txt 파일을 확인해 보세요.");
	}
}
