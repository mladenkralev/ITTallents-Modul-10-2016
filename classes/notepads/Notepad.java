package classes.notepads;

import java.util.Scanner;

import classes.pages.Page;
import interfaces.INotepad;

public abstract class Notepad implements INotepad {

	private final int DEFAULT_PAGES = 10;

	private Page[] pages;
	protected final Scanner sc;

	public Notepad(int numberOfPages) {
		if (numberOfPages <= 0) {
			System.out.println("Pages must be positive");
			pages = new Page[DEFAULT_PAGES];
			fillNotepadWithPages();
			sc = new Scanner(System.in);
			return;
		}
		pages = new Page[numberOfPages];
		fillNotepadWithPages();
		sc = new Scanner(System.in);
	}

	@Override
	public void writeTextOnPage(int id) {
		boolean isItWrittenOnPage = false;

		for (int index = 0; index < pages.length; index++) {
			if ((pages[index] != null) && (pages[index].getId() == id)) {
				System.out.println("Set header");
				pages[index].addHeader(sc.nextLine());
				System.out.println("Write your text");
				pages[index].addText((sc.nextLine()));
				isItWrittenOnPage = true;
			}
		}

		if (!isItWrittenOnPage) {
			System.out.println("Cant be written on pages");
		}
	}

	@Override
	public void reWriteTextOnPage(int id) {
		boolean isItWrittenOnPage = false;

		for (int index = 0; index < pages.length; index++) {
			if ((pages[index] != null) && (pages[index].getId() == id)) {

				if (((pages[index].getText() == null)) || (pages[index].getText().equals(""))) {
					System.out.println("Text was empty so... enter new one");
				} else {
					System.out.println("You are overriting TEXT of " + pages[index]);
				}

				System.out.println("Write your text");
				pages[index].addText((sc.nextLine()));
				isItWrittenOnPage = true;
			}
		}

		if (!isItWrittenOnPage) {
			System.out.println("Cant be written on pages");
		}

	}

	@Override
	public void removeTextOnPage(int id) {
		boolean isItDeletetedAPage = false;

		for (int index = 0; index < pages.length; index++) {
			if ((pages[index] != null) && (pages[index].getId() == id)) {
				pages[index].addHeader("");
				isItDeletetedAPage = true;
			} else {
				System.out.println("Cant remove text, no such page or no such id");
			}
		}

		if (!isItDeletetedAPage) {
			System.out.println("Cant be written on pages");
		}

	}

	@Override
	public void printAllPages() {
		for (int index = 0; index < pages.length; index++) {
			if (pages[index] != null) {
				System.out.println(pages[index]);
			}
		}
	}

	private void fillNotepadWithPages() {
		Page.setCounterOfPages(0);
		for (int index = 0; index < pages.length; index++) {
			if (pages[index] == null) {
				pages[index] = new Page();
			}
		}
	}

	
}
