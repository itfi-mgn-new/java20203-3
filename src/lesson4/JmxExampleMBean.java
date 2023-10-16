package lesson4;

public interface JmxExampleMBean {
	void exit();
	void printMyText();
	void print(String text);
    String getMyText();
    void setMyText(String myText);
    int calculate(int x, char oper, int y);
    // calculate(3,'+',5) -> 8
    String getCurrentState();
    // - OS name
    // - number of processors
    // - memory used
    // - memory free
    // - number of threads
}
