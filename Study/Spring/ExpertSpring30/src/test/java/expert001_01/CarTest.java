package expert001_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void carTest() {
		Car car = new Car();
		
		assertEquals("������ Ÿ�̾�: �ѱ� Ÿ�̾�", car.getTireBrand());
	}

}
