package entities;

// Specialized class

public class Individual extends TaxPayer{
	
	private Double heathExpenditures;
	
	public Individual() {
		
	}
	
	public Individual(String name, Double anualIncome,Double heathExpenditures) {
		super(name, anualIncome);
		this.heathExpenditures = heathExpenditures;
	}
	
	
	public Double getHeathExpenditures() {
		return heathExpenditures;
	}
	
	public void setHeathExpenditures(Double heathExpenditures) {
		this.heathExpenditures = heathExpenditures;
	}
	
	@Override
	public double tax() {
		
		double taxPay = 0.0;
		
		// Calculation of quantity of tax a pay
		taxPay = (getAnualIncome() > 20000.0) ? getAnualIncome() * 0.25 :  getAnualIncome() * 0.15;
		
		// Obtaining amounts spent on healthcare
		taxPay -= (getHeathExpenditures() > 0.0) ? getHeathExpenditures() * 0.5 : 0;
		
		return Math.abs(taxPay);
	
		
	}

}
