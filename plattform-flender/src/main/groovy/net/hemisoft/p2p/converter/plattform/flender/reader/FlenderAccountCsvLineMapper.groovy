package net.hemisoft.p2p.converter.plattform.flender.reader

import org.springframework.stereotype.Component

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.flender.dto.FlenderAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvLineMapper

@Component
class FlenderAccountCsvLineMapper extends AbstractAccountCsvLineMapper<FlenderAccountDto> {
	@Override FlenderAccountDto createNewDto() { FlenderAccountDto.newInstance() }
}