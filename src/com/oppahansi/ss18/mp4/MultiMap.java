/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 */

package com.oppahansi.ss18.mp4;

import java.util.List;
import java.util.Set;

/**
 * An interface a map that can store multiple
 * entries for keys.
 * 
 * @author Marcus
 *
 * @param <K> The type of the key.
 * @param <V> The value of the key.
 */
public interface MultiMap<K, V> {

	/**
	 * Returns the keys stored in the map.
	 * 
	 * @return The keys stored in the map.
	 */
	Set<K> getKeys();
	
	/**
	 * Returns true if the specified key
	 * is contained in the map.
	 * 
	 * @param key The key.
	 * @return True if contained, false otherwise.
	 * @throws NullPointerException Thrown if the key is null.
	 */
	boolean containsKey(K key) throws NullPointerException;
	
	/**
	 * Removes the specified key and returns
	 * the associated values as a list.
	 * 
	 * @param key The key.
	 * @return The list with the values for
	 * 	the key.
	 * @throws NullPointerException Thrown if the key is null.
	 * @throws KeyNotFoundException Thrown if the key is not contained in the map.
	 */
	List<V> removeKey(K key) throws KeyNotFoundException, NullPointerException;
	
	/**
	 * Returns the values stored for the key.
	 * 
	 * @param key The key.
	 * @return The values.
	 * @throws NullPointerException Thrown if the key is null.
	 * @throws KeyNotFoundException Thrown if the key is not contained in the map.
	 */
	List<V> getValues(K key) throws KeyNotFoundException, NullPointerException;
	
	/**
	 * Removes the first occurrence of the value for the key.
	 * 
	 * @param key The key.
	 * @param value The value to remove.
	 * @return True if a value has been removed, false if the value was not found.
	 * @throws KeyNotFoundException Thrown if the key is not contained in the map.
	 * @throws NullPointerException Thrown if the key or the value is null.
	 */
	boolean removeValue(K key, V value) throws KeyNotFoundException, NullPointerException;

	/**
	 * Adds the value for the key.
	 * 
	 * @param key The key.
	 * @param value The value.
	 * @throws NullPointerException Thrown if the key or the value is null.
	 */
	void addValue(K key, V value) throws NullPointerException;

}
