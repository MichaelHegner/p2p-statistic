package net.hemisoft.p2p.converter.plattform.twino.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.plattform.twino.dto.TwinoAccountDto

@Component
class TwinoAccountExcelRowMapper extends AbstractAccountExcelRowMapper<TwinoAccountDto> {
	@Override TwinoAccountDto createNewDto() { TwinoAccountDto.newInstance() }
}