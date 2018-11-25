/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 */

package com.oppahansi.ss18.mp4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A common interface for classes that can read and write multi maps.
 * 
 * @author Marcus
 *
 * @param <K> The type of the keys.
 * @param <V> The type of the values.
 */
public interface MultiMapIO<K, V> {
	
	/**
	 * Writes a multi map to the writer.
	 * 
	 * @param writer The writer.
	 * @param map The map.
	 * @throws IOException Thrown if the map could not be written.
	 */
	void write(BufferedWriter writer, MultiMap<K, V> map) throws IOException;
	
	/**
	 * Read a multi map from the buffered reader.
	 * 
	 * @param reader The reader to read from.
	 * @return The multi map that has been read.
	 * @throws IOException Thrown if the map could not be read.
	 */
	MultiMap<K, V> read(BufferedReader reader) throws IOException;

}
