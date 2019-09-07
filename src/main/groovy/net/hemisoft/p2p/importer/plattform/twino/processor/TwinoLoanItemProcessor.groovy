package net.hemisoft.p2p.importer.plattform.twino.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.twino.dto.TwinoLoanDto

@Component
public class TwinoLoanItemProcessor extends AbstractLoanItemProcessor<TwinoLoanDto, Loan> {

	@Override Loan process(TwinoLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.TWINO }
}
