package net.hemisoft.p2p.converter.plattform.crowdestate.reader

import org.springframework.stereotype.Component

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.crowdestate.dto.CrowdestateAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountExcelRowMapper

@Component
class CrowdestateAccountExcelRowMapper extends AbstractAccountExcelRowMapper<CrowdestateAccountDto> {
	@Override CrowdestateAccountDto createNewDto() { CrowdestateAccountDto.newInstance() }
}
