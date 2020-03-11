import java.awt.event.*;

public class Controller {
	
	private View theView;
	private Operations theModel;
	
	
	public Controller(View view, Operations model) {
		this.theView = view;
		this.theModel = model;
		this.theView.addListener(new AdditionL());
		this.theView.substractListener(new SubstractionL());
		this.theView.integrationListener(new IntegrationL(1));
		this.theView.integrationListenerSecond(new IntegrationL(2));
		this.theView.derivationListener(new DerivationL(1));
		this.theView.derivationListenerSecond(new DerivationL(2));
		this.theView.multiplicationListener(new MultiplicationL());
		this.theView.divisionListener(new DivisionL());
	}
	
	class AdditionL implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			Polynomial p1, p2;
			String s1, s2;
			
			try {
				s1 = theView.getFirstPolynomial();
				s2 = theView.getSecondPolynomial();
				ParsingClass parse = new ParsingClass();
				p1 = new Polynomial(parse.convertFromStringToPolynomial(s1));
				p2 = new Polynomial(parse.convertFromStringToPolynomial(s2));
				theView.setResult(theModel.addOrSubstract(p1, p2, '+').transformPolynomialToString());
			}
			catch(BadInputException ex){
				theView.displayErrorMessage(ex.toString());
			}
		}
	}
	
	class SubstractionL implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			Polynomial p1, p2;
			String s1, s2;
			try {
				s1 = theView.getFirstPolynomial();
				s2 = theView.getSecondPolynomial();
				ParsingClass parse = new ParsingClass();
				p1 = new Polynomial(parse.convertFromStringToPolynomial(s1));
				p2 = new Polynomial(parse.convertFromStringToPolynomial(s2));
				theView.setResult(theModel.addOrSubstract(p1, p2, '-').transformPolynomialToString());
			}
			
			catch(BadInputException ex){
				theView.displayErrorMessage(ex.toString());
			}
		}
	}
	
	class IntegrationL implements ActionListener{
		
		private int whichPol;
		
		IntegrationL(int arg){
			whichPol = arg;
		}

		public void actionPerformed(ActionEvent arg0) {
			Polynomial p1;
			String s1;
			try {
				if(whichPol == 1) {
					s1 = theView.getFirstPolynomial();
				}
				else
					s1 = theView.getSecondPolynomial();
				ParsingClass parse = new ParsingClass();
				p1 = new Polynomial(parse.convertFromStringToPolynomial(s1));
				theView.setResult(theModel.integration(p1).transformPolynomialToString());
			}
			catch(BadInputException ex){
				theView.displayErrorMessage(ex.toString());
			}
		}
		
	}
	
	class DerivationL implements ActionListener{

		private int whichPol;
		
		DerivationL(int arg){
			whichPol = arg;
		}

		public void actionPerformed(ActionEvent arg0) {
			Polynomial p1;
			String s1;
			try {
				if(whichPol == 1) {
					s1 = theView.getFirstPolynomial();
				}
				else
					s1 = theView.getSecondPolynomial();
				ParsingClass parse = new ParsingClass();
				p1 = new Polynomial(parse.convertFromStringToPolynomial(s1));
				theView.setResult(theModel.derivation(p1).transformPolynomialToString());
			}
			catch(BadInputException ex){
				theView.displayErrorMessage(ex.toString());
			}
		}
		
	}
	
	class MultiplicationL implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			Polynomial p1, p2;
			String s1, s2;
			try {
				s1 = theView.getFirstPolynomial();
				s2 = theView.getSecondPolynomial();
				ParsingClass parse = new ParsingClass();
				p1 = new Polynomial(parse.convertFromStringToPolynomial(s1));
				p2 = new Polynomial(parse.convertFromStringToPolynomial(s2));
				theView.setResult(theModel.multiplication(p1, p2).transformPolynomialToString());
			}
			
			catch(BadInputException ex){
				theView.displayErrorMessage(ex.toString());
			}
		}
	}
	
	class DivisionL implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
}
