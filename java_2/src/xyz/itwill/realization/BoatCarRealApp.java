package xyz.itwill.realization;

public class BoatCarRealApp {
	public static void main(String[] args) {
		//BoatCarReal boatCar=new BoatCarReal();
		BoatCar boatCar=new BoatCarReal();//인터페이스로 참조변수를 작성하는 것이
		//더 효율적일 수 있다.
		
		boatCar.run();
		boatCar.seil();
		boatCar.raiz();
	}
}
