package com.defy.designPatterns.builder;

public class LoanBuilderMain {

	
	public static void main(String[] arg) {
		Loan loan = new Loan.LoanBuilder(1234).buildWithHolder("XYM Customer").build();
		System.out.print("Loan details : "+loan);
	}
}
