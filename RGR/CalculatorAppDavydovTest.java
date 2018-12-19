package RGR;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorAppDavydovTest {

	@Test
	public void test() throws InterruptedException {
		Calculator c = new Calculator(); //create instance of the calculator
		c.textField1.setText("1"); //set test in the text field
		c.textField2.setText("2"); //set test in the text field
		c.textField3.setText("3"); //set test in the text field
		c.countB.doClick(); //do click on the button
		assertEquals("4", c.textField4.getText()); //check results
		
	}

}
