package net.hemisoft.p2p.converter.plattform.investly.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.investly.dto.InvestlyAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class InvestlyAccountExcelRowMapper extends AbstractAccountExcelRowMapper<InvestlyAccountDto> {
	@Override InvestlyAccountDto createNewDto() { InvestlyAccountDto.newInstance() }
}