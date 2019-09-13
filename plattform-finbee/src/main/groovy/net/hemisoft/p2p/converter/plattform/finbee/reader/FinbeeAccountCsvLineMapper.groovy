package net.hemisoft.p2p.converter.plattform.finbee.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.finbee.dto.FinbeeAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvLineMapper

@Component
class FinbeeAccountCsvLineMapper extends AbstractAccountCsvLineMapper<FinbeeAccountDto> {
	@Override FinbeeAccountDto createNewDto() { FinbeeAccountDto.newInstance() }
}