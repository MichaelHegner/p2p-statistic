package net.hemisoft.p2p.converter.domain.entity

import static java.math.BigDecimal.ZERO

import java.time.LocalDate

import groovy.transform.ToString

@ToString
class Account {
    Plattform    plattform
    BigDecimal   amount        = ZERO
    TransferType transferType
    LocalDate    issued
}
