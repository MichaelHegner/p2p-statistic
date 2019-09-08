package net.hemisoft.p2p.importer.plattform.robocash.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.importer.plattform.robocash.service.RobocashLoanImportService

@Slf4j
@Component
public class RobocashLoanItemWriter extends AbstractLoanItemWriter {
	 RobocashLoanItemWriter(RobocashLoanImportService service) {
		super(service)
	}
}