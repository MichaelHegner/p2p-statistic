package net.hemisoft.p2p.converter.plattform.dto

import javax.validation.constraints.*

import groovy.transform.builder.Builder

@Builder
class AccountDto {
	@NotNull String    amount
	@NotNull String    transferType
	@NotNull String    issuedDate
}
