package org.perscholas.keyproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

public class KeyChainTest {

	
	@Test
	void testAdd() {
		/*
		 * Given: KeyChain class and Key class
		 * When: Create an instance of the KeyChain class with that of the Key class.
		 * Then: Adding the key should return true
		 */
		
		Key key = new Key();
		KeyChain keyChain = new KeyChain();		
		assertTrue(keyChain.add(key));
		assertEquals(keyChain.toString(), key.toString());
	}
	
	@Test
	void testKeyConstructor() {
		/*
		 * Given: KeyChain class and Key class
		 * When: Create an instance of the KeyChain class and that of the Key class.
		 * Then: The key should be added to the KeyChain object.
		 */
		
		Key key = new Key();
		KeyChain keyChain = new KeyChain(key);		
		assertEquals(keyChain.size(), 1);
	}
	
	@Test
	void testKeyCollectionConstructor() {
		/*
		 * Given: KeyChain class and a Collection of Key objects
		 * When: Create an instance of the KeyChain class and multiple of the Key class.
		 * Then: The keys should be added to the KeyChain object.
		 */
		
		ArrayList<Key> keys = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			keys.add(new Key());
			
		KeyChain keyChain = new KeyChain(keys);		
		assertEquals(keyChain.size(), keys.size());
	}

	
	@Test
	void testRemove() {
		/*
		 * Given: KeyChain class and Key class
		 * When: Create an instance of the KeyChain class with that of the Key class.
		 * Then: Removing the key should return true
		 */
		
		Key key = new Key();
		KeyChain keyChain = new KeyChain(key);		
		assertTrue(keyChain.remove(key));
		assertEquals(keyChain.toString(), "");
	}
			
	@Test
	void testUnlock() {
		/*
		 * Given: KeyChain, Door, and Key class 
		 * When: Create an instance of the KeyChain and the Door class with a Key.
		 * Then: The Door should unlock with the provided key from the KeyChain.
		 */		
		
		Key key1 = new Key();
		Key key2 = new Key();
		KeyChain keyChain1 = new KeyChain(new ArrayList<Key>(Arrays.asList(key1, key2)));
		KeyChain keyChain2 = new KeyChain(key2);
		Door door = new Door(key1);
		
		assertFalse(keyChain2.unlock(door)); // This KeyChain doesn't have the right key for the door
		
		assertTrue(keyChain1.unlock(door));				
	}
	
	@Test
	void testLock() {
		/*
		 * Given: KeyChain, Door, and Key class 
		 * When: Create an instance of the KeyChain and the Door class with a Key.
		 * Then: The Door should lock with the provided key from the KeyChain.
		 */
		Key key1 = new Key();
		Key key2 = new Key();
		KeyChain keyChain = new KeyChain(new ArrayList<Key>(Arrays.asList(key1, key2)));
		KeyChain keyChain2 = new KeyChain(key2);
		Door door = new Door(key1);
		
		
		assertTrue(door.unlock(key1)); // To test KeyChain's lock, the door should be unlocked first
		
		assertFalse(keyChain2.lock(door));// This KeyChain doesn't have the right key for the door	

		assertTrue(keyChain.lock(door));			
	}
}
