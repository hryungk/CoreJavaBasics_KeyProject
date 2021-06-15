package org.perscholas.keyproject;

public class KeyApp {

	public static void main(String[] args) {
		Key key = new Key();
//		key.key = 25; // not allowed
		System.out.println(key);

		// Holders of a Key can create a copy 
		Key spareKey = new Key(key); // using the copy constructor
		Key otherSpareKey = (Key) key.clone(); // using the clone method
		
		Key key1 = new Key();
		Door door = new Door(key1);

		Key key2 = new Key();
		door.unlock(key1);
		System.out.println(door.lock(key2));
		System.out.println(door.lock(key1));
	}

}
