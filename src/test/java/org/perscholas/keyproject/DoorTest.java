package org.perscholas.keyproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoorTest {

	@Test
	void testConstructor() {
		/*
		 * Given: Door class 
		 * When: Create an instance of the Door class and that of the Key class.
		 * Then: The door shouldn't have key and the door should be unlocked.
		 */
		
		Door door = new Door();		
		assertFalse(door.hasKey());
		assertFalse(door.isLocked());
	}
	
	@Test
	void testKeyConstructor() {
		/*
		 * Given: Door class and Key class
		 * When: Create an instance of the Door class and that of the Key class.
		 * Then: The key field should be the same as the input Key object and the door should be locked.
		 */
		
		Key key = new Key();
		Door door = new Door(key);
		
		assertEquals(key.shape(), door.getKeyShape());
		assertTrue(door.isLocked());
	}
		
	@Test
	void testUnlock() {
		/*
		 * Given: Door class and Key class
		 * When: Create an instance of the Door class with a key.
		 * Then: The Door should unlock with the provided key.
		 */		
		
		Key key1 = new Key();
		Door door = new Door(key1);
		
		Key key2 = new Key();
		assertFalse(door.unlock(key2));
		
		assertTrue(door.unlock(key1));		
	}
	
	@Test
	void testLock() {
		/*
		 * Given: Door class and Key class
		 * When: Create an instance of the Door class with a key.
		 * Then: The Door should lock with the provided key.
		 */
		Key key1 = new Key();
		Door door = new Door(key1);

		Key key2 = new Key();
		
		assertTrue(door.unlock(key1));
		
		assertFalse(door.lock(key2));		
		
		assertTrue(door.lock(key1));		
	}
}
