package model.entities;

public class Invoice {
	
	private Double basicPyment;
	private Double tax;
	
	public Invoice(Double basicPyment, Double tax) {
		this.basicPyment = basicPyment;
		this.tax = tax;
	}

	public Double getBasicPyment() {
		return basicPyment;
	}

	public void setBasicPyment(Double basicPyment) {
		this.basicPyment = basicPyment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}


	public Double totalPayment() {
		return basicPyment + tax;
	}
	

}
