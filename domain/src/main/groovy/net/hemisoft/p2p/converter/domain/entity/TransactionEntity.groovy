package net.hemisoft.p2p.converter.domain.entity

import groovy.transform.ToString

@ToString
class TransactionEntity {
    Long id                    // entity id
    String transactionId       // transaction id
    Loan loan                  // id of loan
    BigDecimal investedAmount  // invested amount by user
    Plattform plattform        // p2p plattform
}
 