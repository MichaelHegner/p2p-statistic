package net.hemisoft.p2p.converter.plattform.mintos.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.mintos.dto.MintosAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class MintosAccountExcelRowMapper extends AbstractAccountExcelRowMapper<MintosAccountDto> {
	@Override MintosAccountDto createNewDto() { MintosAccountDto.newInstance() }
}