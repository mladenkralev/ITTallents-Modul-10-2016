package interfaces;

public interface ISecurable {
	boolean checkPasswordForUnlock();
	boolean isStrongPassword(String password);
}
