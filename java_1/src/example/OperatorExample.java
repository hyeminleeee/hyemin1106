package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int time=245678;
		int hours=(time/60)/60%24;
		int min=(time/60)%60;
		int sec=time%60;
		int day=(time/60)/60/24;
		System.out.println(time+"초 : "+day+"일 "+hours+"시 "+min+"분 "+sec+"초");
		System.out.println("==============================================================");
		/* < 강사님 풀이 >
		 * int cho=245678;
		 * int day=cho/(24*60*60);//24*60*60=86400
		 * cho%=86400; //변수에 저장된 초단위 시간에서 몫(일)을 제외한 나머지 값을 계산하여 저장
		 * int hour=cho/(60*60);//60*60=3600
		 * cho%=3600; //변수에 저장된 초단위 시간에서 몫(시간)을 제외한 나머지 값을 계산하여 저장
		 * int min=cho/60;
		 * int sec=cho%60;
		*/
		
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		int price=150000000;
		int air=20;
		if(air > 0) {
			if( air >=15 ) {
				System.out.println("금액 : "+(long)(price*0.75*air)+"원");
			} else {
				System.out.println("금액 :"+(long)(price*air)+"원");
			}
		}
	System.out.println("==============================================================");
	
	/*<강사님 풀이>
	 * int plane=150_000_000, count=20;
	 * long money=(long)(count>=15?plane*0.75:plane)*count;
	 * system.out.println("지불금액 ="+money+"원");
	 * 
	 */
	}
}