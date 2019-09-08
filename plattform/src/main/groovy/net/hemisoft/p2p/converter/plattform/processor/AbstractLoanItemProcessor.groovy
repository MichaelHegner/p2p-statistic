package net.hemisoft.p2p.converter.plattform.processor

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.converter.domain.entity.Loan
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.utils.date.P2PDateUtils
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractLoanItemProcessor<I extends AbstractLoanDto, O extends Loan> implements ItemProcessor<I, O> {

	@Override O process(I dto) throws Exception {
		createPopulated dto
	}
	
	O createPopulated(I dto) {
		def entity            = new Loan()
		entity.loanId         = createLoanId dto
		entity.investedAmount = P2PNumberUtils.createDoubleIfPossible dto.investedAmount
		entity.issued         = P2PDateUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = createPlattform()
		entity
	}
	
	protected String createLoanId(I dto) {
		dto.loanId
	}

	abstract Plattform createPlattform()
}
