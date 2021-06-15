package org.perscholas.keyproject;

import java.util.UUID; // A class that represents an immutable universally unique identifier (UUID). 128-bit value.

/**
 * A Key class that 
 * unlocks a door. 
 * is engraved with a unique pattern (unique).
 * is distinct, until you make a copy. 
 * once created, must not be changed (immutable).  
 */
public class Key implements Cloneable, Comparable<Key> {

	private UUID key; // guaranteed to be unique and immutable
	private KeyShape shape = KeyShape.Unknown;
	
	/** 
	 * Default constructor 
	*/
	public Key() {
		key = UUID.randomUUID();
	}
	
	/**
	 * Constructor with the key's shape
	 * @param shape A KeyShape object that represents the shape of this Key.
	 */
	public Key(KeyShape shape) {
		this();
		this.shape = shape;
	}
	
	/**
	 * Copy constructor that accepts a Key to copy
	 * @param original A Key object to copy the key code from
	 */
	public Key(Key original) {
		key = original.key;
		shape = original.shape;
	}
	
	/**
	 * Returns the key shape of this Key
	 * @return A KeyShape object that represents the shape of this Key
	 */
	public KeyShape shape() {
		return shape;
	}
	
	@Override
	public Object clone() {
		return new Key(this);
	}
	
	@Override
	public String toString() {
		return shape.toString() + "\t" + key.toString();
	}

	@Override
	public int compareTo(Key o) {
		return key.compareTo(o.key);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!getClass().isInstance(o)) return false;
		Key okey = (Key) o;
		return key.equals(okey.key);
	}
	
	@Override
	public int hashCode() {
		return key.hashCode();
	}
}
