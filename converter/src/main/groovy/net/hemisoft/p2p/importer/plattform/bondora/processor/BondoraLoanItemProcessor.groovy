package net.hemisoft.p2p.importer.plattform.bondora.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.bondora.dto.BondoraLoanDto

@Component
public class BondoraLoanItemProcessor extends AbstractLoanItemProcessor<BondoraLoanDto, Loan> {
	@Override Loan process(BondoraLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.BONDORA }
}
