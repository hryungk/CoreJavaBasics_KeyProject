package org.perscholas.keyproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
	
	@Test
	void testConstructorKeyShape() {
		/*
		 * Given: An instance of Key class 
		 * When: Use the KeyShape constructor to create the Key instance
		 * Then: The Key should have a KeyShape assigned.
		 */
		
		Key key1 = new Key(KeyShape.Circular);
		assertEquals(KeyShape.Circular, key1.shape());
	}
	
	@Test
	void textCopyUsingClone() {
		/*
		 * Given: Two instances of Key class 
		 * When: Create a new key using the clone method
		 * Then: The cloned key should be equal to the original key.
		 */
		
		Key key1 = new Key();
		Key key2 = (Key) key1.clone();
		assertEquals(key1, key2);
	}
	
	@Test
	void testCheckCompareTo() {
		/*
		 * Given: Two instances of Key class 
		 * When: Create two keys and compare them.
		 * Then: The compareTo method should not be zero, hence, different.
		 */
		
		Key key1 = new Key();
		Key key2 = new Key();
		assertFalse(key1.compareTo(key2) == 0);
	}
	
	@Test
	void textCheckHashCode() {
		/*
		 * Given: Key class 
		 * When: Calling the key's hashCode method
		 * Then: The hash code will always be the same.
		 */
		
		Key key = new Key();
		int i1 = key.hashCode();
		int i2 = key.hashCode();
		assertEquals(i1, i2);
	}
}
