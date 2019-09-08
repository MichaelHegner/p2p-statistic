package net.hemisoft.p2p.converter.converter.plattform.bondora.writer

import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.converter.plattform.bondora.service.BondoraAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Component
public class BondoraAccountItemWriter extends AbstractAccountItemWriter {
	BondoraAccountItemWriter(BondoraAccountImportService service) {
		super(service)
	}
}