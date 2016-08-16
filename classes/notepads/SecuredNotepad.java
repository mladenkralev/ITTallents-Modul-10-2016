package classes.notepads;

import interfaces.ISecurable;

public class SecuredNotepad extends Notepad implements ISecurable {

	private String password;

	public SecuredNotepad(int numberOfPages) {
		super(numberOfPages);

		boolean isStrong = false;

		do {
			System.out.println("Enter strong password (one upper one lower one digit))");
			String password = super.sc.nextLine();
			if (isStrongPassword(password)) {
				System.out.println("Password accepted");
				this.password = password;
				return;
			}
		} while ((password == null) || (password.equals("")) || (!isStrong));

	}

	@Override
	public boolean checkPasswordForUnlock() {
		System.out.println("Write your password!");
		String password = super.sc.nextLine();

		if (password == null || password.equals("")) {
			return false;
		}

		if (password.equals(this.password)) {
			return true;
		}

		return false;
	}

	@Override
	public void writeTextOnPage(int id) {
		if (checkPasswordForUnlock() == true) {
			super.writeTextOnPage(id);
			return;
		}
		System.out.println("Wrong password");
		return;
	}

	@Override
	public void reWriteTextOnPage(int id) {
		if (checkPasswordForUnlock() == true) {
			super.reWriteTextOnPage(id);
			return;
		}
		System.out.println("Wrong password");
		return;
	}

	@Override
	public void removeTextOnPage(int id) {
		if (checkPasswordForUnlock() == true) {
			super.removeTextOnPage(id);
			return;
		}
		System.out.println("Wrong password");
		return;
	}

	@Override
	public void printAllPages() {
		if (checkPasswordForUnlock() == true) {
			super.printAllPages();
			return;
		}
		System.out.println("Wrong password");
		return;
	}

	@Override
	public boolean isStrongPassword(String password) {
		if (password.length() < 5) {
			System.out.println("Small password");
			return false;
		}

		boolean isConsistDigit = false;
		boolean isConsistUpper = false;
		boolean isConsistLower = false;

		for (int index = 0; index < password.length(); index++) {
			char charAtPosition = password.charAt(index);
			if (charAtPosition >= '0' && charAtPosition <= '9') {
				isConsistDigit = true;
			}
			if (charAtPosition >= 'a' && charAtPosition <= 'z') {
				isConsistLower = true;
			}
			if (charAtPosition >= 'A' && charAtPosition <= 'Z') {
				isConsistUpper = true;
			}
		}

		if (isConsistDigit && isConsistUpper && isConsistLower) {
			return true;
		} else {
			return false;
		}
	}
}
