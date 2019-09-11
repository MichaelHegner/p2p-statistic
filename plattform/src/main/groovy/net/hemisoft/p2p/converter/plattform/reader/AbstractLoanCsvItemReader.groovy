package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.core.io.Resource

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto

abstract class AbstractLoanCsvItemReader<T extends AbstractLoanDto> extends _AbstractCsvItemReader<T> {
	AbstractLoanCsvItemReader(Resource resource, AbstractLoanCsvLineMapper<T> lineMapper, int linesToSkip) {
		super(resource, lineMapper, linesToSkip)
	}
}