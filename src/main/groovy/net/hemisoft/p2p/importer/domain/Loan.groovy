package net.hemisoft.p2p.importer.domain

import java.time.LocalDate

import groovy.transform.ToString

@ToString
class Loan {
	Long      id
	String    loanId	
	Plattform plattform
	Account   account 
	LocalDate issued
	Double    investedAmount = 0.0
	Boolean   closed         = false
}
