package com.defy.designPatterns.builder;

import java.util.Optional;

public class Loan {

	private int accountNumber;
	private String accountHolder;
	private int amount;
	private String status;

	public static class LoanBuilder {

		Loan loan = new Loan();
//		private int accountNumber;
//		private String accountHolder;
//		private int amount;
//		private String status;

		LoanBuilder(int accountNumber) {
			loan.accountNumber = accountNumber;
		}

		LoanBuilder buildWithHolder(String accountHolder) {
			loan.accountHolder = accountHolder;
			return this;
		}

		LoanBuilder buildWithAmount(int amount) {
			loan.amount = amount;
			return this;
		}

		LoanBuilder buildWithStatus(String status) {
			loan.status = status;
			return this;
		}

		Loan build() {
//			Loan loan = new Loan();
//			loan.accountNumber = this.accountNumber;
//			loan.accountHolder = this.accountHolder;
//			loan.amount = this.amount;
//			loan.status = this.status;
			return loan;
		}

	}

	private Loan() {

	}

	@Override
	public String toString() {
		return "account number = " + accountNumber + ", account holder = " + Optional.ofNullable(accountHolder).orElse("\" \"") + ", amount = " + amount
				+ ", status = " + Optional.ofNullable(status).orElse("\" \"");

	}
}
