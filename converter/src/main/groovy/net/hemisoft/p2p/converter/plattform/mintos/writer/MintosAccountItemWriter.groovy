package net.hemisoft.p2p.converter.plattform.mintos.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.mintos.service.MintosAccountImportService

@Slf4j
@Component
public class MintosAccountItemWriter extends AbstractAccountItemWriter {
	 MintosAccountItemWriter(MintosAccountImportService service) {
		super(service)
	}
}