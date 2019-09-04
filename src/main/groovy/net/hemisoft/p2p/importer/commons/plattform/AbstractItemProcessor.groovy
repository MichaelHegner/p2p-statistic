package net.hemisoft.p2p.importer.commons.plattform

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.importer.commons.utils.P2PDateUtils
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public abstract class AbstractItemProcessor<I extends AbstractTransactionDto, O extends Loan> implements ItemProcessor<I, O> {

	@Override O process(I dto) throws Exception {
		createPopulated dto
	}
	
	O createPopulated(I dto) {
		def entity            = new Loan()
		entity.loanId         = dto.loanId
		entity.investedAmount = Double.parseDouble dto.investedAmount
		entity.issued         = P2PDateUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = createPlattform()
		entity
	}

	abstract Plattform createPlattform()
}
