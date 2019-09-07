package net.hemisoft.p2p.importer.plattform.grupeer.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.grupeer.service.GrupeerLoanImportService

@Slf4j
@Component
public class GrupeerLoanItemWriter extends AbstractLoanItemWriter {
	 GrupeerLoanItemWriter(GrupeerLoanImportService service) {
		super(service)
	}
}