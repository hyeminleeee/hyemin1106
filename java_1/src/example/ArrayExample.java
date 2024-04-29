package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		int tot=0;
		for(int i=0;i<age.length;i++) {
			tot+=age[i];
		}
		int ave=tot/age.length;
		System.out.println("나이 평균 : "+ave+"살");
		System.out.println("===============================================================");
		//배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		//ex) 10대 = 3명
		//    20대 = 4명
		//    ...
		//    60대 = 1명
		int cnt=0;
		for(int hum : age) {
			if(hum>=10 && hum<20) {
				cnt++;
			}
		}
		System.out.println("10대 = "+cnt+"명");
		
		
		/*int cnt=0;
		for(int hum : age ) {
			if(hum>=10 && hum<20) {
				cnt++;
				System.out.println("10대 = "+cnt+"명");
			} else if(hum>=20 && hum<30) {
				cnt++;
				System.out.println("20대 = "+cnt+"명");
			} else if(hum>=30 && hum<40) {
				cnt++;
				System.out.println("30대 = "+cnt+"명");
			} else if(hum>=40 && hum<50) {
				cnt++;
				System.out.println("40대 = "+cnt+"명");
			} else if(hum>=50 && hum<60) {
				cnt++;
				System.out.println("50대 = "+cnt+"명");
			} else if(hum>=60 && hum<70) {
				cnt++;
				System.out.println("60대 = "+cnt+"명");
			}
		}*/
		
		System.out.println("===============================================================");
	}
}