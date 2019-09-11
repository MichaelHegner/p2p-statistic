package net.hemisoft.p2p.converter.plattform.bondora.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.bondora.dto.BondoraAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class BondoraAccountExcelRowMapper extends AbstractAccountExcelRowMapper<BondoraAccountDto> {
	@Override BondoraAccountDto createNewDto() { BondoraAccountDto.newInstance() }
}