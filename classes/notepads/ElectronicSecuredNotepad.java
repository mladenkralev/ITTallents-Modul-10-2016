package classes.notepads;

import interfaces.IElectronicDevice;
import interfaces.ISecurable;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice {

	private boolean isOn;

	public ElectronicSecuredNotepad(int numberOfPages) {
		super(numberOfPages);
		isOn = false; // not nessesery
	}

	@Override
	public void start() {
		if (isStarted()) {
			System.out.println("Already on");
			return;
		}
		System.out.println("Brrrrrum");
		this.isOn = true;
	}

	@Override
	public void stop() {
		if (!isStarted()) {
			System.out.println("Already off");
			return;
		}
		System.out.println("Mmmmmmmmmmmmmm off");
		this.isOn = false;
	}

	@Override
	public boolean isStarted() {
		if (isOn == true) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void writeTextOnPage(int id) {
		start();
		super.writeTextOnPage(id);
	}

	@Override
	public void reWriteTextOnPage(int id) {
		start();
		super.reWriteTextOnPage(id);
	}

	@Override
	public void removeTextOnPage(int id) {
		start();
		super.removeTextOnPage(id);
	}

	@Override
	public void printAllPages() {
		start();
		super.printAllPages();
	}
}
