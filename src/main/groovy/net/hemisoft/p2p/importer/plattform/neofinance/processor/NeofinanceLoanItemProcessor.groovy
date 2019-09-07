package net.hemisoft.p2p.importer.plattform.neofinance.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.neofinance.dto.NeofinanceLoanDto

@Component
public class NeofinanceLoanItemProcessor extends AbstractLoanItemProcessor<NeofinanceLoanDto, Loan> {

	@Override
	public Loan process(NeofinanceLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.NEOFINANCE }
}
