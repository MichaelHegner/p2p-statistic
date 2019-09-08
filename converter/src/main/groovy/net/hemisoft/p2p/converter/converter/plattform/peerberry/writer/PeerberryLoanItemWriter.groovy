package net.hemisoft.p2p.converter.converter.plattform.peerberry.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.peerberry.service.PeerberryLoanImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractLoanItemWriter

@Slf4j
@Component
public class PeerberryLoanItemWriter extends AbstractLoanItemWriter {
	PeerberryLoanItemWriter(PeerberryLoanImportService service) {
		super(service)
	}
}