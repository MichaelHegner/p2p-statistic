package net.hemisoft.p2p.converter.plattform.swaper.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.plattform.swaper.dto.SwaperAccountDto

@Component
class SwaperAccountExcelRowMapper extends AbstractAccountExcelRowMapper<SwaperAccountDto> {
	@Override SwaperAccountDto createNewDto() { SwaperAccountDto.newInstance() }
}