package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.core.io.Resource

import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto

abstract class AbstractAccountExcelItemReader<T extends AbstractAccountDto> extends _AbstractExcelItemReader<T> {
	AbstractAccountExcelItemReader(Resource resource, AbstractAccountExcelRowMapper<T> rowMapper, int linesToSkip) {
		super(resource, rowMapper, linesToSkip)
	}
}
