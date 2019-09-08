package net.hemisoft.p2p.converter.plattform.mintos.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.plattform.mintos.service.MintosAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class MintosAccountItemWriter extends AbstractAccountItemWriter {
	 MintosAccountItemWriter(MintosAccountImportService service) {
		super(service)
	}
}