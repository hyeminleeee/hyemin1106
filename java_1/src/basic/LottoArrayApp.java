package basic;

//1~45범위의 정수 난수값을 6개 제공받아 출력하는 프로그램 작성
//=>6개의 난수값은 서로 중복되지 않도록 처리하고 오름차순 정렬하여 출력
//정렬(Sort) : 값을 비교하여 순서대로 나열하는 기능
//=>오름차순(Ascending Sort), 내림차순(Descending Sort)


public class LottoArrayApp {
	public static void main(String[] args) {
		//6개의 정수 난수값을 저장하기 위한 요소를 가진 배열을 생성하여 참조변수에 저장
		int[] lotto=new int[6];
		
		
		//1~45범위의 정수 난수값을 제공받아 배열 요소에 차례대로 저장
		for(int i=0;i<lotto.length;i++) {
			//난수값을 제공받아 요소에 저장하고 이전 요소에 저장된 난수값과 비교하여 같은
			//난수값이 저장되어 있는 경우 새로운 난수값을 요소에 저장하기 위한 반복문
			//=> 제공받은 난수값이 이전에 제공받은 모든 난수값과 비교하여 중복되지 않는 경우 반복문 종료
			//=>중복된 난수값이 배열 요소에 저장되지 않도록 처리
			while(true) {
				//1~45범위의 정수난수값을 배열 요소에 저장
				lotto[i]=(int)(Math.random()*45)+1;
				
				//중복 상태를 저장하기 위한 변수
				//=> false : 미중복, true : 중복
				boolean result=false;
				
				//이전 난수값이 저장된 요소를 처리하기 위한 반복문
				for(int j=0;j<i;j++) {
					//lotto[i]=새로운 난수값이 저장된 배열 요소
					//lotto[j]=이전 난수값이 저장된 배열 요소
					if(lotto[i] == lotto[j]) {//새로운 난수값과 이전난수값이 중복된 경우
						result=true;
						break;//for구문을 종료
					}
				}
				
				if(!result) break;//while(true) 종료
			}	
		}
		
		//배열 요소에 저장된 값을 비교하여 오름차순 정렬되도록 배열 요소값을 바꾸어 저장
		//=> 선택정렬알고리즘(Selection Sort)을 사용하여 오름차순 정렬되도록 처리
		
		for(int i=0;i<lotto.length;i++) {//비교 요소의 첨자를 표현하기 위한 반복문:처음~끝-1
			for(int j=i+1;j<lotto.length; j++) {//피비교 요소의 첨자를 표현하기 위한 반복문 : 비교+1~끝
				//lotto[i] : 비교하는 요소, lotto[j]:비교 당하는 요소
				//비교 요소값이 피비교요소값보다 큰 경우 요소값을 바꾸어 저장 - 오름차순
				if(lotto[i] > lotto[j]) {
					//요소값을 바꾸어 저장하기 위한 치환 알고리즘 사용
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
			
		}
		
		
		
		System.out.print("행운의 숫자 >> ");
		for(int number : lotto) {
			System.out.print(number+" ");
		}
		System.out.println();
	}
}
