package net.hemisoft.p2p.importer.plattform.estateguru

import net.hemisoft.p2p.importer.commons.plattform.AbstractItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform

public class EstateguruItemProcessor extends AbstractItemProcessor<EstateguruTransactionDto, Loan> {

	@Override Loan process(EstateguruTransactionDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.ESTATEGURU }
}
