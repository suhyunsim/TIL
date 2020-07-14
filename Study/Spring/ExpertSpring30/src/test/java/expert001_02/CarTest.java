package expert001_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void carKoreaTireTest() {
		Tire tire1 = new KoreaTire();
		Car car1 = new Car(tire1);
		assertEquals("������ Ÿ�̾�: �ѱ� Ÿ�̾�", car1.getTireBrand());
	}

	@Test
	public void carAmericaaTireTest() {
		Tire tire2 = new AmericaTire();
		Car car2 = new Car(tire2);
		assertEquals("������ Ÿ�̾�: �̱� Ÿ�̾�", car2.getTireBrand());
	}

}
