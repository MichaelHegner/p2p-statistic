package net.hemisoft.p2p.converter.plattform.debitum.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.debitum.dto.DebitumAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class DebitumAccountExcelRowMapper extends AbstractAccountExcelRowMapper<DebitumAccountDto> {
	@Override DebitumAccountDto createNewDto() { DebitumAccountDto.newInstance() }
}
