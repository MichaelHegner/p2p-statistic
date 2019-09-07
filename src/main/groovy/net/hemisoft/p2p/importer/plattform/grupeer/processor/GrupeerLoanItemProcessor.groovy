package net.hemisoft.p2p.importer.plattform.grupeer.processor

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.processor.AbstractLoanItemProcessor
import net.hemisoft.p2p.importer.domain.Loan
import net.hemisoft.p2p.importer.domain.Plattform
import net.hemisoft.p2p.importer.plattform.grupeer.dto.GrupeerLoanDto

@Component
public class GrupeerLoanItemProcessor extends AbstractLoanItemProcessor<GrupeerLoanDto, Loan> {

	@Override Loan process(GrupeerLoanDto dto) throws Exception {
		super.process(dto)
	}
	
	@Override Plattform createPlattform()   { Plattform.GRUPEER }
}
