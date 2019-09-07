package net.hemisoft.p2p.importer.plattform.mintos.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.mintos.service.MintosLoanImportService

@Slf4j
@Component
public class MintosLoanItemWriter extends AbstractLoanItemWriter {
	 MintosLoanItemWriter(MintosLoanImportService service) {
		super(service)
	}
}