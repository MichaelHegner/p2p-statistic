package net.hemisoft.p2p.converter.converter.plattform.bondora.writer

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.bondora.service.BondoraLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Component
public class BondoraLoanItemWriter extends AbstractLoanItemWriter {
	BondoraLoanItemWriter(BondoraLoanImportService service) {
		super(service)
	}
}