
public class FinalDemo {
	private int var;
	// method1 : initialize while declaring
	private final String STR = "Final variable";
	
	// method2 : initilize through a initialization block
	public final String STR1;
	
	{
		STR1 = "Another final";
	}
	// initialize through constructor
	public final String STR2;
	
	public FinalDemo() {
		STR2 = "Final Again";
	}
}
