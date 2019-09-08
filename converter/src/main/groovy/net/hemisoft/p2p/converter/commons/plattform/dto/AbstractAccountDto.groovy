package net.hemisoft.p2p.converter.commons.plattform.dto

import net.hemisoft.p2p.converter.domain.Plattform

abstract class AbstractAccountDto {
	Plattform plattform
	String    amount
	String    transferType
	String    issuedDate
}
