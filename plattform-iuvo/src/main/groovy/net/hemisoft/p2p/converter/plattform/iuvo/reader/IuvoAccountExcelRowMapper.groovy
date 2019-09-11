package net.hemisoft.p2p.converter.plattform.iuvo.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.iuvo.dto.IuvoAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class IuvoAccountExcelRowMapper extends AbstractAccountExcelRowMapper<IuvoAccountDto> {
	@Override IuvoAccountDto createNewDto() { IuvoAccountDto.newInstance() }
}