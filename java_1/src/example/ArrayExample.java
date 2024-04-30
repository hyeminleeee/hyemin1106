package example;

public class ArrayExample {
	public static void main(String[] args) {
		//사람들의 나이를 저장한 배열 생성하여 참조변수에 저장		
		int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
		
		//배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
		int tot=0;
		//for(int nai : age ) {
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
		/*int cnt10=0, cnt20=0, cnt30=0, cnt40=0, cnt50=0, cnt60=0;
		for(int hum : age) {
			if(hum>=10 && hum<20) cnt10++;
			else if(hum>=20 && hum<30) cnt20++;
			else if(hum>=30 && hum<40) cnt30++;
			else if(hum>=40 && hum<50) cnt40++;
			else if(hum>=50 && hum<60) cnt50++;
			else if(hum>=60 && hum<70) cnt60++;
			
		}
		System.out.println("10대 = "+cnt10+"명");
		System.out.println("20대 = "+cnt20+"명");
		System.out.println("30대 = "+cnt30+"명");
		System.out.println("40대 = "+cnt40+"명");
		System.out.println("50대 = "+cnt50+"명");
		System.out.println("60대 = "+cnt60+"명");*/
		
		int[] cnt=new int[6];
		
		for(int nai : age) {
			switch(nai/10) {
			case 1: cnt[0]++; break;
			case 2: cnt[1]++; break;
			case 3: cnt[2]++; break;
			case 4: cnt[3]++; break;
			case 5: cnt[4]++; break;
			case 6: cnt[5]++; break;
			}
		}
		for(int i=0; i<cnt.length;i++) {
			System.out.println(((i+1)*10)+"대 = "+cnt[i]+"명");
		}
		
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