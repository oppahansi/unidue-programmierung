/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp4;

import java.util.*;

/**
 * Implements a multimap using a hashmap that contains
 * array lists to store its elements.
 *
 * @author Marcus
 *
 * @param <K> The key.
 * @param <V> The value.
 */
public class MultiHashMap<K, V> implements  MultiMap<K, V> {

    private Map<K, List<V>> map;

    public MultiHashMap() {
        map = new HashMap<>();
    }

    @Override
    public void addValue(K key, V value) throws NullPointerException {
        if (key == null) throw new NullPointerException("Key cannot be null.");
        else if (value == null) throw new NullPointerException("Value cannot be null.");
        else if (!containsKey(key)) insertNewKeyPair(key, value);
        else insertNewValueForKey(key, value);
    }

    private void insertNewKeyPair(K key, V value) {
        List<V> list = new ArrayList<>(Arrays.asList(value));
        map.put(key, list);
    }

    private void insertNewValueForKey(K key, V value) {
        map.get(key).add(value);
    }

    @Override
    public List<V> getValues(K key) throws KeyNotFoundException, NullPointerException {
        if (key == null) throw new NullPointerException("Key cannot be null.");
        else if (!containsKey(key)) throw new KeyNotFoundException("Key could not be found.");
        else return map.get(key);
    }

    @Override
    public List<V> removeKey(K key) throws KeyNotFoundException, NullPointerException {
        if (key == null) throw new NullPointerException("Key cannot be null.");
        else if (!containsKey(key)) throw new KeyNotFoundException("Key could not be found.");
        else {
            List<V> list = map.get(key);
            map.remove(key);
            return list;
        }
    }

    @Override
    public boolean removeValue(K key, V value) throws KeyNotFoundException, NullPointerException {
        if (key == null) throw new NullPointerException("Key cannot be null.");
        else if (value == null) throw new NullPointerException("Value cannot be null");
        else if (!containsKey(key)) throw new KeyNotFoundException("Key could not be found.");
        else {
            if (map.get(key).contains(value)) {
                map.get(key).remove(value);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Set<K> getKeys() {
        return map.keySet();
    }

    @Override
    public boolean containsKey(K key) throws NullPointerException {
        if (key == null) throw new NullPointerException("Key cannot be null.");
        else return getKeys().contains(key);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (K key : getKeys()) {
            for (V value : map.get(key)) {
                builder.append(key.toString()).append(" = ").append(value.toString()).append(System.lineSeparator());
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) throws KeyNotFoundException {
        MultiHashMap<String, String> multiHashMap0 = new MultiHashMap<>();

        multiHashMap0.addValue("one", "valueOne0");
        multiHashMap0.addValue("one", "valueOne1");
        multiHashMap0.addValue("one", "valueOne2");

        multiHashMap0.addValue("two", "valueTwo0");
        multiHashMap0.addValue("two", "valueTwo1");
        multiHashMap0.addValue("two", "valueTwo2");

        multiHashMap0.addValue("three", "valueThree0");
        multiHashMap0.addValue("three", "valueThree1");
        multiHashMap0.addValue("three", "valueThree2");

        multiHashMap0.addValue("four", "valueFour0");
        multiHashMap0.addValue("four", "valueFour1");
        multiHashMap0.addValue("four", "valueFour2");

        multiHashMap0.addValue("five", "valueFive0");
        multiHashMap0.addValue("five", "valueFive1");

        System.out.println("--- Initial state (STRING, STRING) ---");
        System.out.println(multiHashMap0.toString() + System.lineSeparator());

        System.out.println("--- After removing keys ---");
        multiHashMap0.removeKey("one");
        multiHashMap0.removeKey("three");
        System.out.println(multiHashMap0.toString() + System.lineSeparator());

        System.out.println("--- After removing values ---");
        multiHashMap0.removeValue("two", "valueTwo0");
        multiHashMap0.removeValue("two", "valueTwo1");
        multiHashMap0.removeValue("four", "valueFour0");
        multiHashMap0.removeValue("four", "valueFour2");
        System.out.println(multiHashMap0.toString() + System.lineSeparator());

        System.out.println("--- Removing null key ---");
        try {
            multiHashMap0.removeKey(null);
            System.out.println("Removing a null key was a success, you did something wrong.");
        } catch (NullPointerException e) {
            System.out.println("Removing a null key resulted correctly in a NullPointerException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println("--- Removing null value ---");
        try {
            multiHashMap0.removeValue("five", null);
            System.out.println("Removing a null value was a success, you did something wrong.");
        } catch (NullPointerException e) {
            System.out.println("Removing a null value resulted correctly in a NullPointerException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println("--- Removing a nonexistent key ---");
        try {
            multiHashMap0.removeKey("six");
            System.out.println("Removing a nonexistent key was a success, you did something wrong.");
        } catch (KeyNotFoundException e) {
            System.out.println("Removing a nonexistent key resulted correctly in a KeyNotFoundException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println("---------------------------------------------------");

        MultiHashMap<Integer, String> multiHashMap1 = new MultiHashMap<>();

        multiHashMap1.addValue(1, "one0");
        multiHashMap1.addValue(1, "one1");
        multiHashMap1.addValue(1, "one2");

        multiHashMap1.addValue(2, "two0");
        multiHashMap1.addValue(2, "two1");
        multiHashMap1.addValue(2, "two2");

        multiHashMap1.addValue(3, "three0");
        multiHashMap1.addValue(3, "three1");
        multiHashMap1.addValue(3, "three2");

        multiHashMap1.addValue(4, "four0");
        multiHashMap1.addValue(4, "four1");
        multiHashMap1.addValue(4, "four2");

        multiHashMap1.addValue(5, "five0");
        multiHashMap1.addValue(5, "five1");

        System.out.println("--- Initial state (INTEGER, STRING) ---");
        System.out.println(multiHashMap1.toString() + System.lineSeparator());

        System.out.println("--- After removing keys ---");
        multiHashMap1.removeKey(1);
        multiHashMap1.removeKey(3);
        System.out.println(multiHashMap1.toString() + System.lineSeparator());

        System.out.println("--- After removing values ---");
        multiHashMap1.removeValue(2, "two0");
        multiHashMap1.removeValue(2, "two1");
        multiHashMap1.removeValue(4, "four0");
        multiHashMap1.removeValue(4, "four2");
        System.out.println(multiHashMap1.toString() + System.lineSeparator());

        System.out.println("--- Removing null key ---");
        try {
            multiHashMap1.removeKey(null);
            System.out.println("Removing a null key was a success, you did something wrong.");
        } catch (NullPointerException e) {
            System.out.println("Removing a null key resulted correctly in a NullPointerException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println("--- Removing null value ---");
        try {
            multiHashMap1.removeValue(5, null);
            System.out.println("Removing a null value was a success, you did something wrong.");
        } catch (NullPointerException e) {
            System.out.println("Removing a null value resulted correctly in a NullPointerException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }

        System.out.println("--- Removing a nonexistent key ---");
        try {
            multiHashMap1.removeKey(6);
            System.out.println("Removing a nonexistent key was a success, you did something wrong.");
        } catch (KeyNotFoundException e) {
            System.out.println("Removing a nonexistent key resulted correctly in a KeyNotFoundException:");
            System.out.println(e.getMessage() + System.lineSeparator());
        }
    }
}
