package net.hemisoft.p2p.converter.plattform.robocash.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper
import net.hemisoft.p2p.converter.plattform.robocash.dto.RobocashAccountDto

@Component
class RobocashAccountExcelRowMapper extends AbstractAccountExcelRowMapper<RobocashAccountDto> {
	@Override RobocashAccountDto createNewDto() { RobocashAccountDto.newInstance() }
}