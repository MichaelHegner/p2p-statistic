package net.hemisoft.p2p.converter.plattform.estateguru.reader

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.estateguru.dto.EstateguruAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvLineMapper

@Component
class EstateguruAccountCsvLineMapper extends AbstractAccountCsvLineMapper<EstateguruAccountDto> {
	@Override EstateguruAccountDto createNewDto() { EstateguruAccountDto.newInstance() }
}
