package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.core.io.Resource

import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto

abstract class AbstractAccountCsvItemReader<T extends AbstractAccountDto> extends _AbstractCsvItemReader<T> {
	AbstractAccountCsvItemReader(Resource resource, AbstractAccountCsvLineMapper<T> lineMapper, int linesToSkip) {
		super(resource, lineMapper, linesToSkip)
	}
}
