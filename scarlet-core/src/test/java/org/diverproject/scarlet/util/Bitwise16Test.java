package org.diverproject.scarlet.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bitwise (16 bits)")
public class Bitwise16Test {

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Bitwise16 bitwise = new Bitwise16();
		assertEquals((byte) 0, bitwise.getValue());
		assertEquals(16, bitwise.getProperties().length);

		bitwise = new Bitwise16((byte) 1);
		assertEquals((byte) 1, bitwise.getValue());
		assertEquals(16, bitwise.getProperties().length);

		String[] properties = new String[] { "FIRST", "SECOND", "THIRD" };
		bitwise = new Bitwise16(properties);
		assertEquals((byte) 0, bitwise.getValue());
		assertEquals(properties, bitwise.getProperties());
	}

	@Test
	@DisplayName("Has bit property")
	public void hasProperty() {
		short first = 0x01;
		short second = 0x02;
		short third = 0x04;
		short all = (short) (first + second + third);

		Bitwise16 bitwise = new Bitwise16(all);
		assertTrue(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise = new Bitwise16((short) (all - first));
		assertFalse(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise = new Bitwise16((short) (all - second));
		assertTrue(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise = new Bitwise16((short) (all - third));
		assertTrue(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertFalse(bitwise.has(third));

		bitwise = new Bitwise16();
		assertFalse(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertFalse(bitwise.has(third));
	}

	@Test
	@DisplayName("set property")
	public void setProperty() {
		short first = 0x01;
		short second = 0x02;
		short third = 0x04;

		Bitwise16 bitwise = new Bitwise16();
		assertFalse(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertFalse(bitwise.has(third));

		bitwise.set(first);
		assertTrue(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertFalse(bitwise.has(third));

		bitwise.set(second);
		assertTrue(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertFalse(bitwise.has(third));

		bitwise.set(third);
		assertTrue(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertTrue(bitwise.has(third));
	}

	@Test
	@DisplayName("set property")
	public void removeProperty() {
		short first = 0x01;
		short second = 0x02;
		short third = 0x04;
		short all = (short) (first + second + third);

		Bitwise16 bitwise = new Bitwise16(all);
		assertTrue(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise.remove(first);
		assertFalse(bitwise.has(first));
		assertTrue(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise.remove(second);
		assertFalse(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertTrue(bitwise.has(third));

		bitwise.remove(third);
		assertFalse(bitwise.has(first));
		assertFalse(bitwise.has(second));
		assertFalse(bitwise.has(third));
	}

	@Test
	public void testToString() {
		String[] properties = new String[] { "FIRST", "SECOND", "THIRD" };
		Bitwise16 bitwise = new Bitwise16((short) 15, properties);
		assertEquals("Bitwise16{value=15, properties=FIRST|SECOND|THIRD|0x0008}", bitwise.toString());
	}

}