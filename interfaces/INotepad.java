package interfaces;

public interface INotepad {
	void writeTextOnPage(int id);
	void reWriteTextOnPage(int id);
	void removeTextOnPage(int id);
	void printAllPages();
}
