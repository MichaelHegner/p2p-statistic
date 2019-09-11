package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class FinbeeAccountExcelRowMapper extends AbstractAccountExcelRowMapper<FinbeeAccountDto> {
	@Override FinbeeAccountDto createNewDto() { FinbeeAccountDto.newInstance() }
}