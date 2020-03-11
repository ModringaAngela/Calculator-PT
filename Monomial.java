
public class Monomial implements Comparable <Monomial>{
	private float coefficient;
	private Integer degree;
	
	public Monomial(float c, int d){
		this.coefficient = c;
		this.degree = d;
	}
	
	// don t need setters
	public void setCoeff(float f) {
		this.coefficient = f;
	}
	
	public void setDegree(int d) {
		this.degree = d;
	}

	public float getCoefficient() {
		return this.coefficient;
	}
	
	public Integer getDegree() {
		return this.degree;
	}

	public int compareTo(Monomial o) {
		return this.getDegree().compareTo(o.getDegree());
	}
	
	public boolean equals(Monomial m) {
		if(this.coefficient != m.coefficient || this.degree != m.degree)
			return false;
		return true;
		
	}
}
