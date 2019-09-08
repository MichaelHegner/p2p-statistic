package net.hemisoft.p2p.converter.converter.plattform.mintos.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.mintos.service.MintosLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class MintosLoanItemWriter extends AbstractLoanItemWriter {
	 MintosLoanItemWriter(MintosLoanImportService service) {
		super(service)
	}
}