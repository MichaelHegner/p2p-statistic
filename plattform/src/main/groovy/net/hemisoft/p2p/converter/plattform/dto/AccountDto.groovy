package net.hemisoft.p2p.converter.plattform.dto

import groovy.transform.builder.Builder
import net.hemisoft.p2p.converter.domain.entity.Plattform

@Builder
class AccountDto {
	Plattform plattform
	String    amount
	String    transferType
	String    issuedDate
}
