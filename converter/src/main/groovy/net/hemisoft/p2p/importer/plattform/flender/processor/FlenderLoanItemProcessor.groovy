package net.hemisoft.p2p.importer.plattform.flender.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.flender.dto.FlenderLoanDto

@Component
public class FlenderLoanItemProcessor extends AbstractLoanItemProcessor<FlenderLoanDto, Loan> {

	@Override Loan process(FlenderLoanDto dto) throws Exception {
		super.process(dto)
	}

	@Override Plattform createPlattform()   { Plattform.FLENDER }
}
