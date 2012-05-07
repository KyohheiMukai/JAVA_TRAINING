package ch03.ex03_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testClone() {

		Vehicle v1 = new Vehicle("Mukai");
		try {
			Vehicle v2 = v1.clone();
			assertEquals(v1,v2);
		} catch (CloneNotSupportedException e) {
			System.out.println("CloneNotSupportedExceptionにより、複製失敗");
		}

	}

}
