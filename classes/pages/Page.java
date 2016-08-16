package classes.pages;

import java.util.Arrays;

import interfaces.IContainsDigits;
import interfaces.ISearchable;

public class Page implements ISearchable, IContainsDigits {

	private static int counterOfPages = 1;
	private int id;
	private String text;
	private String header;

	public Page() {
		id = counterOfPages++;
	}

	public void addText(String text) {
		this.text = text;
	}

	public void deleteText() {
		this.text = null;
	}

	public void addHeader(String header) {
		this.header = header;
	}

	@Override
	public boolean search(String word) {
		if (this.header != null) {
			String[] headerWords = this.header.split(" ");
			for (int index = 0; index < headerWords.length; index++) {
				if (headerWords[index].equalsIgnoreCase(word)) {
					return true;
				}
			}
		}
		if (this.text != null) {
			String[] textWords = this.text.split(" ");
			for (int index = 0; index < textWords.length; index++) {
				if (textWords[index].equalsIgnoreCase(word)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean isContainingDigits() {
		if (this.header != null) {
			for (int index = 0; index < header.length(); index++) {
				if (Character.isDigit(header.charAt(index))) {
					return true;
				}
			}
		}
		if (this.text != null) {
			for (int index = 0; index < text.length(); index++) {
				if (Character.isDigit(text.charAt(index))) {
					return true;
				}
			}
		}
		return false;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getHeader() {
		return header;
	}

	@Override
	public String toString() {
		if ((this.header == null) && (this.text == null)) {
			return "empty page" + "\n\npage:" + id + "\n";

		}

		/*
		 * Not possible but still i have to check if someone is playing with my
		 * code
		 */

		if ((this.text == null)) {
			return header + "\n\npage:" + id + "\n";
		}

		if ((this.header == null)) {
			return header + "\n\npage:" + id + "\n";
		}

		return header + "\n\n" + text + "\n" + "page:" + id + "\n";
	}

	public static void setCounterOfPages(int counterOfPages) {
		if (counterOfPages >= 0) {
			Page.counterOfPages = counterOfPages;
		}
	}

}
