package net.hemisoft.p2p.importer.plattform.bondora.writer

import org.springframework.stereotype.Component

import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.importer.plattform.bondora.service.BondoraAccountImportService

@Component
public class BondoraAccountItemWriter extends AbstractAccountItemWriter {
	BondoraAccountItemWriter(BondoraAccountImportService service) {
		super(service)
	}
}