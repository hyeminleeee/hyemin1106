package sunday;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int time=245678;
		int day = time/60/60/24;
		time%=60*60*24;
		int hour = time/60/60;
		time%=60*60;
		int min=time/60;
		int sec=time%60;
			
		System.out.println(time+"초 = "+day+"일 "+hour+"시 "+min+"뷴 "+sec+"초");	
		System.out.println("==============================================================");
		
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		int price=150000000;
		int cnt=20;
		
		if(cnt>=15) {
			System.out.println("금액 : "+(long)price*cnt*0.75);
		} else if(cnt<15) {
			System.out.println("금액 ; "+(long)price*cnt);
		}		
		System.out.println("==============================================================");
	
	}
}