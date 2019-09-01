package net.hemisoft.p2p.importer.domain

import groovy.transform.ToString

@ToString
class TransactionEntity {
	Long id                    // entity id
	String transactionId       // transaction id
	String loanId              // id of loan
	BigDecimal investedAmount  // invested amount by user
	Plattform plattform        // p2p plattform
}
 