
import java.util.*;
import java.lang.Math;

public class Operations {
	
	private Polynomial result;
	
	public Operations() {
		
	}
	
	public Polynomial addOrSubstract(Polynomial pol1, Polynomial pol2, char sign) {
		List<Monomial> resultList = new ArrayList<Monomial>();
		List<Monomial> terms1 = pol1.getPolynomial();
		List<Monomial> terms2 = pol2.getPolynomial();
		//common degrees or just in the first list
		for(Monomial m : terms1) {  
			Integer degree = m.getDegree();
			float coefficient = matchingDegreeMonomialsCoeff(terms2, degree);
			if(sign == '+')
				resultList.add(new Monomial( m.getCoefficient() + coefficient, m.getDegree()));
			if(sign == '-')
				resultList.add(new Monomial(m.getCoefficient() - coefficient, m.getDegree()));
		}
		for(Monomial m2 : terms2 ) {
			Integer degree = m2.getDegree();
			float coefficient = m2.getCoefficient();
			if(matchingDegreeMonomialsCoeff(terms1, degree) == 0) { // only in the second list
				if(sign == '+')
					resultList.add(new Monomial(coefficient, degree));
				else
					resultList.add(new Monomial(-coefficient, degree));
			}
		}
		Collections.sort(resultList, Collections.reverseOrder());
		return new Polynomial (resultList);
	}

	public static float matchingDegreeMonomialsCoeff(List<Monomial> list, Integer degree) { 
		for(Monomial m : list) {
			if(m.getDegree() == degree)
				return m.getCoefficient();
			}
		return 0;
	}
	
	public static Monomial matchingDegreeMonomial(List<Monomial> list, Integer degree) {
		for(Monomial m : list) {
			if(m.getDegree() == degree)
				return m;
			}
		return null;
	}
	
	public Polynomial derivation(Polynomial pol1) {
		List<Monomial> terms = new ArrayList<Monomial>();
		terms = pol1.getPolynomial();
		List<Monomial> resultList = new ArrayList<Monomial>();
		for(Monomial m : terms) {
			int degree = m.getDegree();
			float coefficient = m.getCoefficient();
			if(degree != 0) {
				resultList.add(new Monomial(coefficient*degree, degree-1));
			}
		}
		return new Polynomial(resultList);
	}
	
	public Polynomial integration(Polynomial pol1) {
		List<Monomial> terms = new ArrayList<Monomial>();
		terms = pol1.getPolynomial();
		List<Monomial> resultList = new ArrayList<Monomial>();
		for(Monomial m : terms) {
			int degree = m.getDegree();
			float coefficient = m.getCoefficient();  
			resultList.add(new Monomial (coefficient / (degree + 1), degree+1));
		}
		return new Polynomial(resultList);
	}
	
	public Polynomial multiplication(Polynomial pol1, Polynomial pol2) {
		List<Monomial> resultList = new ArrayList<Monomial>();
		List<Monomial> terms1 = pol1.getPolynomial();
		List<Monomial> terms2 = pol2.getPolynomial();
		for(Monomial m1 : terms1) {
			for(Monomial m2 : terms2) {
				Integer degree = m1.getDegree() + m2.getDegree();
				float coefficient = m1.getCoefficient()*m2.getCoefficient();
				Monomial mon = matchingDegreeMonomial(resultList, degree);
				if(mon == null) {
					resultList.add(new Monomial(coefficient, degree));
				}
				else {
					mon.setCoeff(coefficient + mon.getCoefficient()); 
				}	
			}
		}
		Collections.sort(resultList, Collections.reverseOrder());
		
		return new Polynomial(resultList);
	}
	
	public Polynomial getResult() {
		return result;
	}
	
}
