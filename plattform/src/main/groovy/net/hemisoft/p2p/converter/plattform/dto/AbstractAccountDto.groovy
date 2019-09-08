package net.hemisoft.p2p.converter.plattform.dto

import net.hemisoft.p2p.converter.domain.entity.Plattform

abstract class AbstractAccountDto {
	Plattform plattform
	String    amount
	String    transferType
	String    issuedDate
}
