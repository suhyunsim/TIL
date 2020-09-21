package expert001_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void carKoreaTire() {
		Tire tire1 = new KoreaTire();
		Car car1 = new Car();
		car1.setTire(tire1);
		
		assertEquals("������ Ÿ�̾�: �ѱ� Ÿ�̾�", car1.getTireBrand());
	}

	@Test
	public void carAmericaTire() {
		Tire tire2 = new AmericaTire();
		Car car2 = new Car();
		car2.setTire(tire2);
		
		assertEquals("������ Ÿ�̾�: �̱� Ÿ�̾�", car2.getTireBrand());
	}

}
