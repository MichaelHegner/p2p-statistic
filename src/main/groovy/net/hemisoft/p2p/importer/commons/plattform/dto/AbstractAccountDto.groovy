package net.hemisoft.p2p.importer.commons.plattform.dto

import net.hemisoft.p2p.importer.domain.Plattform

abstract class AbstractAccountDto {
	Plattform plattform
	String    amount
	String    transferType
	String    issuedDate
}
