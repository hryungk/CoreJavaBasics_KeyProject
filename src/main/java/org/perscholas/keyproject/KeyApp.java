package org.perscholas.keyproject;

public class KeyApp {

	public static void main(String[] args) {
		Key key = new Key();
//		key.key = 25; // not allowed
		System.out.println(key);

		// Holders of a Key can create a copy 
		Key spareKey = new Key(key); // using the copy constructor
		Key otherSpareKey = (Key) key.clone(); // using the clone method
	}

}
