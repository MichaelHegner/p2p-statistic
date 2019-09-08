package net.hemisoft.p2p.converter.plattform.robocash.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.robocash.service.RobocashLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class RobocashLoanItemWriter extends AbstractLoanItemWriter {
	 RobocashLoanItemWriter(RobocashLoanImportService service) {
		super(service)
	}
}