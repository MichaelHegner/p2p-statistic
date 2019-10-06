package net.hemisoft.p2p.converter.domain.entity

import java.time.LocalDate

import groovy.transform.ToString

@ToString
class Account {
	Plattform    plattform
	Double       amount = 0
	TransferType transferType
	LocalDate    issued
}
