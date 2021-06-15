package org.perscholas.keyproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeyTest {

	
	@Test
	void testConstructor() {
		/*
		 * Given: Key class
		 * When: Create two instances of the class
		 * Then: The key (id) fields should be different
		 */
		
		Key key1 = new Key();
		Key key2 = new Key();
		
		assertNotEquals(key1, key2);
	}
	
	@Test
	void testConstructorCopy() {
		/*
		 * Given: An instance of Key class
		 * When: Use the copy constructor to duplicate the Key instance
		 * Then: Items should be equal
		 */
		
		Key key = new Key();
		Key keyCopy = new Key(key);
		assertEquals(key, keyCopy);
	}
}
