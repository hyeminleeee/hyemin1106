package oop;

import java.util.Arrays;

//배열에 저장된 요소값을 오름차순 정렬하여 출력하는 프로그램 작성
public class ArraySortApp {
	public static void main(String[] args) {
		/*int[] array= {30,50,10,20,40};
		
		System.out.print("정렬 전 >> ");
		for(int number : array) {
			System.out.print(number+" ");
		}
		System.out.println();
		
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i] > array[j]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		System.out.print("정렬 후 >> ");
		for(int number : array) {
			System.out.print(number+" ");
	}
		System.out.println();*/
		
		int[] array= {30,50,10,20,40};
		
		//Arrays.toString(Object[] array) : 메소드의 매개변수로 배열을 전달받아 배열의
		//모든 요소값을 특정한 형태의 문자열로 변환하여 반환하는 메소드
		System.out.println("정렬 전 >> "+Arrays.toString(array));
		
		//Arrays.toString(Object[] array) : 메소드의 매개변수로 배열을 전달받아 배열의
		//모든 요소값들을 정렬하는 메소드
		Arrays.sort(array);
		
		System.out.println("정렬 후 >> "+Arrays.toString(array));
	}
	
}
