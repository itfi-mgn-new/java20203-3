package lesson4;

public interface JmxExampleMBean {
	void exit();
	void printMyText();
	void print(String text);
    String getMyText();
    void setMyText(String myText);
}
