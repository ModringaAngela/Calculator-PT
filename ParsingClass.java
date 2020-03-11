import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingClass {
	
	public List<Monomial> convertFromStringToPolynomial (String text) {
		List<Monomial> monomsList = new ArrayList<Monomial>();
		text = text.replace("-", "+-");
		text = text.replaceAll("\\s+", "");
		text = text.replace("-x", "-1x");
		text = text.replace("-X", "-1X");
		String splitingPattern = "[+]";
		String monoms[] = text.split(splitingPattern);
		String regex = "([+-]?[0-9]*[xX]?[\\Q^\\E]?[0-9]*)";
		Pattern pat = Pattern.compile(regex);
		int coeff;
		int degree;
		for(String s : monoms) {
			if(!s.isEmpty()) { //ca sa mearga si pentru primul termen
				Matcher mt = pat.matcher(s);
				String[] coefAndDeg = s.split("([xX][\\Q^\\E]?)");
				if(!mt.matches()) {
					throw new BadInputException();
				}
				if(!(s.contains("x") || s.contains("X"))) { // n are x^
					degree = 0;
					coeff = Integer.parseInt(s);
				}
				else{ // are x
					if(s.charAt(0) == 'x' || s.charAt(0) == 'X') { // n are coeficient
						coeff = 1;
					}
					else { // are coeficient
						 coeff = Integer.parseInt(coefAndDeg[0]);
					}
					if(s.contains("^")) {
						degree = Integer.parseInt(coefAndDeg[1]);
					}
					else {
						degree = 1;
					}
				}
				monomsList.add(new Monomial((float)coeff, degree));
		}
		}
		return monomsList;
	}
}
