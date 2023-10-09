package lesson4;

public class JmxExample implements JmxExampleMBean{
	private String	myText = "";
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void printMyText() {
		System.err.println("My Text="+myText);
	}
	
	@Override
	public void print(final String text) {
		System.err.println("Text="+text);
	}

	@Override
	public String getMyText() {
		return myText;
	}

	@Override
	public void setMyText(final String myText) {
		System.err.println("Set my text to "+myText);
		this.myText = myText;
	}
}
