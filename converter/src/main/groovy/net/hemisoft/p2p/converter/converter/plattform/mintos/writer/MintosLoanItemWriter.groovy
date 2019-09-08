package net.hemisoft.p2p.converter.converter.plattform.mintos.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.converter.plattform.mintos.service.MintosLoanImportService

@Slf4j
@Component
public class MintosLoanItemWriter extends AbstractLoanItemWriter {
	 MintosLoanItemWriter(MintosLoanImportService service) {
		super(service)
	}
}