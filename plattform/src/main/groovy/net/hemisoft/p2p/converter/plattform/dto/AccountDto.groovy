package net.hemisoft.p2p.converter.plattform.dto

import javax.validation.constraints.*

import groovy.transform.ToString
import groovy.transform.builder.Builder

@Builder
@ToString
class AccountDto {
	@NotNull String issuedDate
	@NotNull String amount
	@NotNull String transferType
	         String transferStatus
}
