package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일(c:\data\bandizip.exe)에 저장된 내용을 원시데이터로 읽어 타겟파일(c:\data\bandizip_byte.exe)에 
//전달하여 저장하는 프로그램 작성 - 파일 복사 프로그램
public class FileCopyByteApp {
	public static void main(String[] args) throws IOException {
		//BufferedInputStreamn 클래스 : 대량의 원시데이터를 전달받을 수 있는 입력스트림을
		//생성하기 위한 클래스
		//=> BufferedInputStreamn(InputStream in) 생성자를 사용해 BufferedInputStreamn 객체 생성
		//=> 매개변수로 입력스트림(InputStream 객체)을 전달받아 대량의 원시데이터를 전달받을
		BufferedInputStream in=null;
		try {
			in=new BufferedInputStream(new FileInputStream("c:\\data\\bandizip.exe"));
		} catch (FileNotFoundException e) {
			System.out.println("[에러]c:/data/byte.txt 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		//BufferedInputStreamn 클래스 : 대량의 원시데이터를 전달할 수 있는 출력스트림을
		//생성하기 위한 클래스
		//=> BufferedOutputStream(OutputStream out) 생성자를 사용해 BufferedInputStreamn 객체 생성
		//=> 매개변수로 입력스트림(OutputStream 객체)을 전달받아 대량의 원시데이터를 전달할 수 있는
		BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("c:/data/bandizip_byte.exe"));
		
		int readByte;
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			out.write(readByte);

		}
		
		in.close();
		out.close();
		
		System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		
	}
}
