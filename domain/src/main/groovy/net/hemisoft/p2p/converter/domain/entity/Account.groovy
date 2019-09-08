package net.hemisoft.p2p.converter.domain.entity

import java.time.LocalDate

class Account {
	Plattform    plattform
	Double       amount = 0
	TransferType transferType
	LocalDate    issued
}
