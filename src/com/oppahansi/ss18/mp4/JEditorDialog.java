/*
 * Created by: Network Embedded Systems, Universität Duisburg-Essen
 */

package com.oppahansi.ss18.mp4;

import java.io.File;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/**
 * A utility class to gather inputs using dialogs.
 * 
 * @author Marcus
 */
public class JEditorDialog {

	/**
	 * The return type when showing a key-value dialog.
	 * 
	 * @author Marcus
	 */
	public static class KeyValueResult {
		/**
		 * The key as entered by the user.
		 */
		public final String key;
		/**
		 * The value as entered by the user.
		 */
		public final String value;
		/**
		 * A flag to indicate whether the user pressed the ok button.
		 */
		public final boolean ok;

		/**
		 * Creates a new result.
		 * 
		 * @param key The key.
		 * @param value The value.
		 * @param ok True if the user pressed ok.
		 */
		public KeyValueResult(String key, String value, boolean ok) {
			this.key = key;
			this.value = value;
			this.ok = ok;
		}
	}

	/**
	 * Shows a dialog that enables a user to edit a key value pair.
	 * 
	 * @param title The title of the dialog.
	 * @param key The initial value of the key.
	 * @param value The initial value of the value.
	 * @return The result with the updated key value pair and a flag to indicate whether
	 * 	the user pressed ok.
	 */
	public static KeyValueResult showKeyValueDialog(String title, String key, String value) {
		JTextField keyField = new JTextField(10);
		keyField.setText(key);
		JTextField valueField = new JTextField(10);
		valueField.setText(value);
		JPanel dialogPanel = new JPanel();
		dialogPanel.add(new JLabel("Key:"));
		dialogPanel.add(keyField);
		dialogPanel.add(Box.createHorizontalStrut(15)); // a spacer
		dialogPanel.add(new JLabel("Value:"));
		dialogPanel.add(valueField);
		boolean ok = JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, dialogPanel, title,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		return new KeyValueResult(keyField.getText(), valueField.getText(), ok);
	}
	
	
	/**
	 * The result of showing a file chooser dialog.
	 * 
	 * @author Marcus
	 */
	public static class FileResult {
		/**
		 * The selected file.
		 */
		public final File file;
		/**
		 * A flag to indicate whether the user pressed ok.
		 */
		public final boolean ok;
		
		/**
		 * Creates a new file result.
		 * 
		 * @param file The selected file.
		 * @param ok True to s
		 */
		public FileResult(File file, boolean ok) {
			this.file = file;
			this.ok = ok;
		}
	}
	
	/**
	 * Shows a file chooser to select an existing file open.
	 * 
	 * @return The result of the operation.
	 */
	public static FileResult showOpenFileDialog() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Configuration files (.config)";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".config") && f.exists() && f.isFile() && f.canRead();
			}
		});
		boolean ok = JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null);
		return new FileResult(chooser.getSelectedFile(), ok);
	}
	
	/**
	 * Shows a file chooser dialog to save a file.
	 * 
	 * @return The result of the operation.
	 */
	public static FileResult showSaveFileDialog() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Configuration files (.config)";
			}
			
			@Override
			public boolean accept(File f) {
				return f.getName().endsWith(".config");
			}
		});
		boolean ok = JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null);
		File file = chooser.getSelectedFile();
		if (ok && ! file.getName().endsWith(".config")) {
			file = new File(file.getParent(), file.getName() + ".config");
		}
		return new FileResult(file, ok);
	}
	
	/**
	 * Shows an error dialog with the specified title and message.
	 * 
	 * @param title The title.
	 * @param message The message.
	 */
	public static void showErrorDialog(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

}
