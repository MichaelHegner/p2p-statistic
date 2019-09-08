package net.hemisoft.p2p.converter.converter.plattform.robocash.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.robocash.service.RobocashLoanImportService

@Slf4j
@Component
public class RobocashLoanItemWriter extends AbstractLoanItemWriter {
	 RobocashLoanItemWriter(RobocashLoanImportService service) {
		super(service)
	}
}