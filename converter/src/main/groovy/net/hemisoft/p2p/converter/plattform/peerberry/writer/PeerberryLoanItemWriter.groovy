package net.hemisoft.p2p.converter.plattform.peerberry.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractLoanItemWriter
import net.hemisoft.p2p.converter.plattform.peerberry.service.PeerberryLoanImportService

@Slf4j
@Component
public class PeerberryLoanItemWriter extends AbstractLoanItemWriter {
	PeerberryLoanItemWriter(PeerberryLoanImportService service) {
		super(service)
	}
}