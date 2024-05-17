package xyz.itwill.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//java.util.function 패키지 : 함수형 인터페이스가 선언된 패키지
//=> 함수형 인터페이스를 사용해 람다 표현식으로 객체 생성
//함수형 인터페이스 : 단 하나의 추상메소드만을 가지는 인터페이스

public class LamdaApp {
	public static void main(String[] args) {
		//Consumer<T> 함수형 인터페이스 : 제네릭으로 전달된 Java 자료형의 객체를 매개변수로
		//전달받아 아무것도 반환하지 않는 accept() 추상메소드가 작성된 함수형 인터페이스
		int number=100;
		
		/*
		//Consumer 인터페이스를 상속받은 익명클래스를 사용해 객체를 생성하여 참조변수에 저장
		Consumer<Integer> integerConsumer=new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {//매개변수를 받아 처리하고 아무것도 반환하지 않는 메소드
				System.out.println(number+ i);
			}
		};=> 함수형 인터페이스는 익명클래스를 사용해 객체 생성하지 X
		*/
		
		//Consumer 함수형 인터페이스를 람다표현식을 사용해 객체 생성하여 참조변수에 저장
		Consumer<Integer> integerConsumer=i -> System.out.println(number+i);
		//메소드 이름 생략, 매개변수 자료형 생략, 매개변수가 하나면 괄호 생략, 오버라이딩 선언된 메소드의
		//작성된 명령 입력 => 명령 하나면 괄호 생략 가능
		
		integerConsumer.accept(200);//아무런 값도 반환하지 않고 명령만 실행
		System.out.println("================================================================");
		
		//Predicate<T> 함수형 인터페이스 : 제네릭으로 전달된 Java 자료형의 객체를 매개변수로
		//제공받아 논리값(boolean)을 반환하는 test() 추상메소드가 작성된 함수형 인터페이스
		Predicate<Integer> isEven = i -> i % 2 == 0;
		
		if(isEven.test(10)) {
			System.out.println("입력값은 [짝수]입니다.");
		} else {
			System.out.println("입력값은 [홀수]입니다.");	
		}
		System.out.println("================================================================");
		
		//Function<T, R> 함수형 인터페이스 : 첫번째 제네릭으로 전달된 Java 자료형의 객체를 매개변수로
		//전달받아 처리하고 두번째 제네릭으로 전달된 Java 자료형의 객체를 반환하는 apply() 추상메소드가
		//작성된 함수형 인터페이스
		Function<String, Integer> stringLength = str -> str.length();
		//=> String을 전달받아 Integer로 반환
		System.out.println("문자 갯수 = "+stringLength.apply("Java Programming"));
		System.out.println("================================================================");
	}

}




























