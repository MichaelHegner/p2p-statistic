package net.hemisoft.p2p.converter.plattform.viventor.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.plattform.viventor.dto.ViventorAccountDto

@Component
class ViventorAccountExcelRowMapper extends AbstractAccountExcelRowMapper<ViventorAccountDto> {
	@Override ViventorAccountDto createNewDto() { ViventorAccountDto.newInstance() }
}