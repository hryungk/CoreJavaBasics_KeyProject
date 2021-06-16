package org.perscholas.keyproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeSet;

/**
 * A KeyChain class that is a collection of Keys.
 * Each Key on a chain is unique.
 * When we encounter a Door, we can search the KeyChain for the right key to open that Door.
 */
public class KeyChain {

//	private Set<Key> keys = new TreeSet<>(); // Using a Set to hold keys enforces uniqueness 
	private HashMap<KeyShape, ArrayList<Key>> keys = new HashMap<>();
	
	/**
	 * Default constructor
	 */
	public KeyChain() {
		
	}
	
	/**
	 * Constructor that accepts a Key object
	 * @param key A Key object to add to this KeyChain
	 */
	public KeyChain(Key key) {
		add(key);
	}
	
	/**
	 * Constructor that accepts a collection of Key objects
	 * @param keys A Collection of Key objects to add to this KeyChain
	 */
	public KeyChain(Collection<Key> keys) {
//		this.keys.addAll(keys);
		for (Key k : keys) {
			add(k);
		}
	}
	
	/**
	 * Returns how many keys are on the chain
	 * @return The number of Key objects on this KeyChain
	 */
	public int size() {
//		return keys.size();
		int count = 0;
		for (KeyShape ks : keys.keySet()) {
			count += keys.get(ks).size();
		}
		return count;
	}
	
	/**
	 * Adds a key to the chain
	 * @param key A Key object to add to this KeyChain
	 * @return true if the addition was successful
	 */
	public boolean add(Key key) {
//		return keys.add(key);		
		keys.putIfAbsent(key.shape(), new ArrayList<Key>());
		return keys.get(key.shape()).add(key);		
	}
	
	/**
	 * Removes a key from the chain
	 * @param key A Key object to delete from this KeyChain
	 * @return true if the removal was successful
	 */
	public boolean remove(Key key) {
//		return keys.remove(key);
		if (keys.containsKey(key.shape())) {
			return keys.get(key.shape()).remove(key);
		}
		return false;
	}
	
	/**
	 * Search for the right key to lock a Door
	 * @param door A Door object to lock
	 * @return true if locking was successful
	 */
	public boolean lock(Door door) {
		boolean isLocked = door.isLocked();
		/* If the door is already locked */
		if (isLocked) 
			return true;
		
		/* If the door is not locked, then find a key to lock it. */		
		/** If the door doesn't have a key **/
		if (!door.hasKey())  
			return false; // the door cannot be locked
		/** If the door has a key **/
		/*** If the KeyChain doesn't have keys with the same shape ***/
		if (!keys.containsKey(door.getKeyShape()))
			return isLocked; // Can't do anything
		/*** If the KeyChain has keys with the same shape ***/
		ArrayList<Key> keysOfAShape = keys.get(door.getKeyShape());
		Iterator<Key> it = keysOfAShape.iterator();
		while (!isLocked && it.hasNext()) {
			isLocked = door.lock(it.next());
		}		
				
//		Iterator<Key> it = keys.iterator();
//		while (!isLocked && it.hasNext()) {
//			isLocked = door.lock(it.next());
//		}
		
		return isLocked;
	}
	
	/**
	 * Search for the right key to unlock a Door
	 * @param door A Door object to unlock
	 * @return true if unlocking was successful
	 */
	public boolean unlock(Door door) {
		boolean isUnlocked = !door.isLocked();
		/* If the door is already unlocked */
		if (isUnlocked) 
			return true;		
		
		/* If the door is locked, then find a key to unlock it. */		
		/** If the door doesn't have a key **/
		if (!door.hasKey())  
			return false; // the door cannot be unlocked
		/** If the door has a key **/
		/*** If the KeyChain doesn't have keys with the same shape ***/
		if (!keys.containsKey(door.getKeyShape()))
			return isUnlocked; // Can't do anything
		/*** If the KeyChain has keys with the same shape ***/
		ArrayList<Key> keysOfAShape = keys.get(door.getKeyShape());
		Iterator<Key> it = keysOfAShape.iterator();
		while (!isUnlocked && it.hasNext()) {
			isUnlocked = door.unlock(it.next());
		}		
		
//		Iterator<Key> it = keys.iterator();
//		while (!isUnlocked && it.hasNext()) {
//			isUnlocked = door.unlock(it.next());
//		}
		
		return isUnlocked;
	}
	
	@Override
	public String toString() {
		String result = "";
		if (size() == 0)
			return result;
		
		for (KeyShape ks : keys.keySet()) {
			ArrayList<Key> kList = keys.get(ks);
			for (Key k : kList) {
				result += k.toString() + "\n";
			}
		}
		result = result.substring(0,result.length()-1);
		return result;
	}
}
