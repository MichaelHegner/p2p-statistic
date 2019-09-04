package net.hemisoft.p2p.importer.domain

import java.time.LocalDate

import groovy.transform.ToString

@ToString
class Loan {
	Long      id
	String    loanId	
	Plattform plattform 
	LocalDate issued
	double    investedAmount
	boolean   closed
}
