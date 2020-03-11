import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame{
	private JTextField firstPol = new JTextField();
	private JTextField secondPol = new JTextField();
	private JButton addButton = new JButton("+");
	private JButton substractButton = new JButton("-");
	private JButton divisionButton = new JButton("/");
	private JButton multiplicationButton = new JButton("*");
	private JButton derivateFirst = new JButton("dx");
	private JButton integrateFirst = new JButton("integrate");
	private JButton derivateSecond= new JButton("dx");
	private JButton integrateSecond = new JButton("integrate");
	private JTextField result = new JTextField();
	private JLabel rules = new JLabel();
	private JLabel example = new JLabel();
	
	View(){
		JPanel calculator = new JPanel();
		calculator.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		rules.setBounds(30, 200, 450, 20);
		example.setBounds(30, 230, 450, 20);
		rules.setText("RULES: You should insert a polynomial of a single variable \"x\"");
		example.setText("Example of accepted polynomial : -3x^4+x^2-7x+5");
		
		firstPol.setBounds(30, 10, 200, 20);
		derivateFirst.setBounds(240, 10, 60, 22);
		integrateFirst.setBounds(310, 10, 100, 22);
		
		secondPol.setBounds(30, 45, 200, 20);
		derivateSecond.setBounds(240, 45, 60, 22);
		integrateSecond.setBounds(310, 45, 100, 22);
		
		addButton.setBounds(33, 80, 42, 22);
		substractButton.setBounds(83, 80, 42, 22);
		multiplicationButton.setBounds(133, 80, 42, 22);
		divisionButton.setBounds(183, 80, 42, 22);
		
		result.setBounds(30, 115, 300, 20);
		
		calculator.add(firstPol);
		calculator.add(example);
		calculator.add(rules);
		calculator.add(secondPol);
		calculator.add(addButton);
		calculator.add(substractButton);
		calculator.add(multiplicationButton);
		calculator.add(divisionButton);
		calculator.add(integrateFirst);
		calculator.add(derivateFirst);
		calculator.add(integrateSecond);
		calculator.add(derivateSecond);
		calculator.add(result);
		this.add(calculator);
	}
	
	public String getFirstPolynomial(){
		return this.firstPol.getText();
	}
	
	public String getSecondPolynomial(){
		return this.secondPol.getText();
	}
	
	public void setResult(String myString) {
		this.result.setText(myString);
	}
	
	void derivationListener(ActionListener listener) {
		derivateFirst.addActionListener(listener);
	}
	
	void integrationListener (ActionListener listener) {
		integrateFirst.addActionListener(listener);
	}

	void derivationListenerSecond(ActionListener listener) {
		derivateSecond.addActionListener(listener);
	}
	
	void integrationListenerSecond(ActionListener listener) {
		integrateSecond.addActionListener(listener);
	}
	
	void addListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	
	void substractListener (ActionListener listener) {
		substractButton.addActionListener(listener);
	}
	
	void divisionListener(ActionListener listener) {
		divisionButton.addActionListener(listener);
	}
	
	void multiplicationListener(ActionListener listener) {
		multiplicationButton.addActionListener(listener);
	}
	
	void displayErrorMessage(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
	
}

