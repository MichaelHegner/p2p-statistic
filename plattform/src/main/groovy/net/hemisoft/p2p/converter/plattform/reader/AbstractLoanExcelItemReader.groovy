package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.core.io.Resource

import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto

abstract class AbstractLoanExcelItemReader<T extends AbstractLoanDto> extends _AbstractExcelItemReader<T> {
	AbstractLoanExcelItemReader(Resource resource, AbstractLoanExcelRowMapper<T> rowMapper, int linesToSkip) {
		super(resource, rowMapper, linesToSkip)
	}
}