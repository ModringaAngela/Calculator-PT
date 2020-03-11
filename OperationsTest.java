import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationsTest {
	
	//Add Division Test

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddGood() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "5x^4+x^3+x^2+3x-2";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.addOrSubstract(a, b, '+');
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertTrue(expectedResult.equals(actualResult));
	}
	
	@Test
	void testAddWrong() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "3x^4+2x^4+x^3+x^2+3x";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.addOrSubstract(a, b, '+');
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertFalse(expectedResult.equals(actualResult));
	}
	
	@Test
	void testSubGood() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "1x^4-x^3+x^2-x+4";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.addOrSubstract(a, b, '-');
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertTrue(expectedResult.equals(actualResult));
	}
	
	@Test
	void testSubWrong() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "1x^4-x^3-x^2-x-2";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.addOrSubstract(a, b, '-');
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertFalse(expectedResult.equals(actualResult));
	}
	
	@Test
	void testMulGood() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "6x^8+3x^7+2x^6+9x^5-6x^4+3x^3-x^2-x-3";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.multiplication(a, b);
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertTrue(expectedResult.equals(actualResult));
	}
	
	@Test
	void testMulWrong() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "2x^4+x^3+2x-3";
		String s3 = "6x^8+3x^7+6x^5-9x^4+2x^6+x^5+2x^3-2x^2+2x^5+x^4+2x^2-3x+2x^4+x^3+2x-3";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial b = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.multiplication(a, b);
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s3));
		assertFalse(expectedResult.equals(actualResult));
	}
	
	@Test
	void testDerivGood() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "12x^3+2x+1";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial actualResult = op.derivation(a);
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s2));
		assertTrue(expectedResult.equals(actualResult));
	}
	
	@Test
	void testDerivWrong() {
		Operations op = new Operations();
		String s1 = "3x^4+x^2+x+1";
		String s2 = "12x^3+2x+2";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial actualResult = op.derivation(a);
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s2));
		assertFalse(expectedResult.equals(actualResult));
	}
	
	@Test
	void testIntegGood() {
		Operations op = new Operations();
		String s1 = "5x^4+4x^3+2x+1";
		String s2 = "x^5+x^4+x^2+x";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.integration(a);
		assertTrue(expectedResult.equals(actualResult));
	}
	
	@Test
	void testIntegWrong() {
		Operations op = new Operations();
		String s1 = "5x^4+4x^3+2x+1";
		String s2 = "x^5+x^4+x^2+2x";
		ParsingClass parse = new ParsingClass();
		Polynomial a = new Polynomial(parse.convertFromStringToPolynomial(s1));
		Polynomial expectedResult = new Polynomial(parse.convertFromStringToPolynomial(s2));
		Polynomial actualResult = op.integration(a);
		assertFalse(expectedResult.equals(actualResult));
	}
}
