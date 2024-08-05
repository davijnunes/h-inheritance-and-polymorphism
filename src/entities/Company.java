package entities;

public class Company extends TaxPayer {
	
	private Integer numberOfEmployee;
	
	public Company() {
		
	}
	
	public Company(String name, Double anualIncome, Integer numberOfEmployee) {
		super(name, anualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}
	
	public Integer getNumberOfEmployee() {
		return numberOfEmployee;
	}
	
	public void setNumberOfEmployee(Integer numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	

	
	@Override
	public double tax() {
		
		double taxPay = 0.0;
		
		taxPay = (getNumberOfEmployee() < 10) ? getAnualIncome() * 0.16 : getAnualIncome() * 0.14;
		
		return taxPay;
	}

}
