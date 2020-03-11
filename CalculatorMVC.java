
//Model Classes : ParsingClass and Operations

public class CalculatorMVC {
	
	public static void main(String[] args) {
		View theView = new View();
		Operations operations = new Operations();
		Controller theController = new Controller(theView, operations);
		theView.setVisible(true);
	}

}
