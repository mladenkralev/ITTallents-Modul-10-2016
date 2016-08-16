package demo;

import classes.notepads.ElectronicSecuredNotepad;
import classes.notepads.Notepad;
import classes.notepads.SecuredNotepad;
import classes.notepads.SimpleNotepad;
import classes.pages.Page;
import interfaces.INotepad;

public class Demo {
	public static void main(String[] args) {
		Notepad ele = new ElectronicSecuredNotepad(10);
		ele.writeTextOnPage(1);

		Notepad pad = new SimpleNotepad(10);
		pad.printAllPages();
		pad.writeTextOnPage(0);
		
			
		Page page = new Page();
		page.setHeader("mladen");
		System.out.println(page.isContainingDigits());
		
		INotepad notepad = new SimpleNotepad(10);
		notepad.writeTextOnPage(0);
		notepad.printAllPages();
	}
}
