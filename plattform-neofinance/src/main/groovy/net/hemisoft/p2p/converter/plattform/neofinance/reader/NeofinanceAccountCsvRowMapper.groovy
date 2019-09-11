package net.hemisoft.p2p.converter.plattform.neofinance.reader

import org.springframework.stereotype.Component

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.neofinance.dto.NeofinanceAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvLineMapper

@Component
class NeofinanceAccountCsvRowMapper extends AbstractAccountCsvLineMapper<NeofinanceAccountDto> {
	@Override NeofinanceAccountDto createNewDto() { NeofinanceAccountDto.newInstance() }
}