/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 * Solved/Edited by Oppa Hansi. Possible solution - there are other ways to solve these tasks.
 */

package com.oppahansi.ss18.mp4;

import java.io.*;

/**
 * A utility class that reads and writes multi maps containing strings
 * to a file in the following format: key = value\newline
 * 
 * @author Marcus
 */
public class StringMapIO implements MultiMapIO<String, String> {

    @Override
    public MultiMap<String, String> read(BufferedReader reader) throws IOException {
        if (reader == null) throw new IOException("BufferedReader cannot be null.");
        else return buildMap(reader);
    }

    private MultiMap<String, String> buildMap(BufferedReader reader) throws IOException {
        MultiMap<String, String> map = new MultiHashMap<>();
        String line;
        String seperator = " = ";

        while((line = reader.readLine()) != null) {
            if (!line.contains(seperator)) throw new IOException("Key-Value seperator could not be found in line: " + line);
            else {
                int seperatorIndex = line.indexOf(seperator);
                String key = (line.substring(0, seperatorIndex)).replace("==", "=");
                String value = (line.substring(seperatorIndex + seperator.length())).replace("==", "=");

                map.addValue(key, value);
            }
        }

        reader.close();

        return map;
    }

    @Override
    public void write(BufferedWriter writer, MultiMap<String, String> map) throws IOException {
        if (writer == null) throw new IOException("BufferedWriter cannot be null.");
        else if (map == null) throw new NullPointerException("Map cannot be null.");
        else saveMapToFile(writer, map);
    }

    private void saveMapToFile(BufferedWriter writer, MultiMap<String, String> map) throws IOException {
        String seperator = " = ";

        for (String key : map.getKeys()) {
            String parsedKey = key.replace("=", "==");

            try {
                for (String value : map.getValues(key)) {
                    String parsedValue = value.replace("=", "==");
                    writer.write(parsedKey + seperator + parsedValue + System.lineSeparator());
                }
            } catch (KeyNotFoundException e) {
                throw new IOException("Key: " + key + " could not be found. MultiMap implementation seems to be wrong." + e.getMessage());
            }
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "test.config";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        MultiMap<String, String> multiMap = new MultiHashMap<>();
        StringMapIO stringMapIO = new StringMapIO();

        multiMap.addValue("one", "value = One0");
        multiMap.addValue("one", "valueO =ne1");
        multiMap.addValue("one", "valueOne2");

        multiMap.addValue("two", "valueTwo0");
        multiMap.addValue("two", "valueTwo1");
        multiMap.addValue("two", "valueTwo2");

        multiMap.addValue("three", "valueThree0");
        multiMap.addValue("three", "valueThree1");
        multiMap.addValue("three", "valueThree2");

        multiMap.addValue("four", "valueFour0");
        multiMap.addValue("four", "valueFour1");
        multiMap.addValue("four", "valueFour2");

        multiMap.addValue("fi = ve", "valueFi = ve0");
        multiMap.addValue("fi = ve", "valueF = ive1");

        stringMapIO.write(bufferedWriter, multiMap);
        bufferedWriter.close();

        MultiMap<String, String> multiMapFromFile = stringMapIO.read(bufferedReader);
        bufferedReader.close();

        System.out.println("Map from code:" + System.lineSeparator() + multiMap.toString() + System.lineSeparator());
        System.out.println("Map from file:" + System.lineSeparator() + multiMapFromFile.toString() + System.lineSeparator());
    }
}
