package net.hemisoft.p2p.converter.plattform.bondora.writer

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.plattform.bondora.service.BondoraLoanImportService

@Component
public class BondoraLoanItemWriter extends AbstractLoanItemWriter {
	BondoraLoanItemWriter(BondoraLoanImportService service) {
		super(service)
	}
}