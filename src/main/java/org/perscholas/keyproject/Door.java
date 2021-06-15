package org.perscholas.keyproject;

/**
 * A Door class that a Key implies.
 * A Door  has state:
 * 	A Door is locked or unlocked.
 * 	A Door has a key.
 * 	Some Doors have no key.
 * 		Doors without a key have no lock.
 * 		They are always unlocked.
 */
public class Door {
	
	private Key key;
	private boolean isLocked;
	
	/**
	 * Constructor of a Door with a matching Key
	 * @param key A Key object that fits this door lock
	 */
	public Door(Key key) {
		this.key = key;
		isLocked = key != null;
	}
	
	/**
	 * Checks whether this Door has a Key
	 * @return true if the Door has a Key assigned to it
	 */
	public boolean hasKey() {
		return key != null;
	}
	
	/**
	 * Returns the Key to this Door
	 * @return A Key object that represents the key to this Door
	 */
	public Key getKey() {
		return key;
	}
	
	/**
	 * Checks whether this Door is locked
	 * @return true if the Door is locked
	 */
	public boolean isLocked() {
		return isLocked;
	}
	
	/**
	 * Locks this Door with a Key
	 * @param key A Key object to lock this Door
	 * @return true if the door was locked
	 */
	public boolean lock(Key key) {
		// If there is no key, the door is always unlocked.
		if (this.key == null)
			isLocked = false;
		else if (this.key.equals(key)) // If there is a key, the input key should match this door's key to lock the door 
			isLocked = true;		
		return isLocked;
	}
	
	/**
	 * Unlocks this Door with a Key
	 * @param key A Key object to unlock this Door
	 * @return true if the door was unlocked
	 */
	public boolean unlock(Key key) {
		// If there is no key, the door is always unlocked.
		if (this.key == null)
			isLocked = false;
		else if (this.key.equals(key)) // If there is a key, the input key should match this door's key to unlock the door
			isLocked = false;		
		return !isLocked;	
	}

}
