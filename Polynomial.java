import java.util.*;

import org.junit.platform.commons.util.CollectionUtils;

public class Polynomial {

	private List<Monomial> terms = new ArrayList<Monomial>();
	
	public Polynomial(List<Monomial> monoms) {
		for(Monomial m : monoms) {
			this.terms.add(m);
		}
	}
	
	public Polynomial() {
		
	}
	
	public List<Monomial> getPolynomial (){
		return this.terms;
	}
	
	public void displayPolynomial() {
		for(Monomial mono : this.terms) {
			if(mono.getCoefficient() != 0 || mono.getDegree() != 0) {
				if(mono.getCoefficient() > 0)
					System.out.print("+");
				System.out.print(mono.getCoefficient());
				if(mono.getDegree() != 0)
					System.out.print("x^" + mono.getDegree());	
		}
		}
		System.out.println();
		System.out.println();
			
	}
	
	public String transformPolynomialToString() {
		String output = new String(" ");
		for(Monomial m : this.terms) {
			float coef = m.getCoefficient();
			int intCoef = (Math.round(coef));
			if(coef > 0)
				output += '+';
			if(coef == intCoef)
				output += String.valueOf(intCoef);
			else
				output += String.format("%.2f", coef);
			if(m.getDegree() > 0)
				output += "x";
			if(m.getDegree() > 1) {
				output += "^";
				output += String.valueOf(m.getDegree());
			}
		}
		if(output.equals(" "))
			output += "0";
		return output;
	}
	
	public boolean equals(Polynomial anotherPolynomial) {
		int i, j;
		int size1 =  this.terms.size();
		int size2 = anotherPolynomial.terms.size();
		if(size1 != size2)
			return false;
		for(i = 0, j = 0; i < size1 || j < size2; i++, j++) {
				Monomial m1 = this.terms.get(i);
				Monomial m2 = anotherPolynomial.terms.get(j);
				if(!m1.equals(m2))
					return false;
		}
		return true;
	}
	
}
