package net.hemisoft.p2p.converter.domain

import java.time.LocalDate

class Account {
	Plattform    plattform
	Double       amount = 0
	TransferType transferType
	LocalDate    issued
}
