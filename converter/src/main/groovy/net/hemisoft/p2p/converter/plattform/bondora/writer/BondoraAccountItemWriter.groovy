package net.hemisoft.p2p.converter.plattform.bondora.writer

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.bondora.service.BondoraAccountImportService

@Component
public class BondoraAccountItemWriter extends AbstractAccountItemWriter {
	BondoraAccountItemWriter(BondoraAccountImportService service) {
		super(service)
	}
}