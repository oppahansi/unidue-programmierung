/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
  */

package com.oppahansi.ss18.mp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Implements a table model that allows us to show the
 * contents in the multimap in a table.
 * 
 * @author Marcus
 *
 */
public class JEditorModel extends AbstractTableModel {

	/**
	 * The serialization version.
	 */
	private static final long serialVersionUID = -1498513669991364790L;
	/**
	 * The data as a table.
	 */
	private List<String[]> cache = null;

	/**
	 * The data that we are supposed to be displaying.
	 */
	private MultiMap<String, String> data;

	/**
	 * Creates a new table model for the data.
	 * 
	 * @param data The data.
	 */
	public JEditorModel(MultiMap<String, String> data) {
		this.data = data;
	}
	
	/**
	 * Sets the underlying data and signals a change
	 * to any connected table.
	 * 
	 * @param data The data to set.
	 */
	public void setData(MultiMap<String, String> data) {
		this.data = data;
		fireTableDataChanged();
	}
	
	/**
	 * Returns a reference to the underlying data.
	 * 
	 * @return The reference to the underlying data.
	 */
	public MultiMap<String, String> getData() {
		return data;
	}

	/**
	 * Returns the data as a table or builds it up.
	 * 
	 * @return The data as a table.
	 */
	private List<String[]> getCache() {
		if (cache == null) {
			cache = new ArrayList<>();
			List<String> keys = new ArrayList<>(data.getKeys());
			Collections.sort(keys);
			for (String k : keys) {
				try {
					List<String> values = new ArrayList<>(data.getValues(k));
					Collections.sort(values);
					for (String v : values) {
						cache.add(new String[] { k, v });
					}
				} catch (KeyNotFoundException e) {
					throw new RuntimeException("Bug in multi map.", e);
				}
			}

		}
		return cache;
	}

	/**
	 * Returns the column names to be displayed at the top of the table.
	 */
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Key";
		case 1:
			return "Value";
		default:
			return "";
		}
	};

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getCache().get(rowIndex)[columnIndex];
	}

	@Override
	public int getRowCount() {
		return getCache().size();
	}

	/**
	 * Invalidates the cache and generates the event.
	 */
	public void fireTableDataChanged() {
		cache = null;
		super.fireTableDataChanged();
	};

	@Override
	public int getColumnCount() {
		return 2;
	}

}