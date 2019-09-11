package net.hemisoft.p2p.converter.plattform.grupeer.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.grupeer.dto.GrupeerAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class GrupeerAccountExcelRowMapper extends AbstractAccountExcelRowMapper<GrupeerAccountDto> {
	@Override GrupeerAccountDto createNewDto() { GrupeerAccountDto.newInstance() }
}