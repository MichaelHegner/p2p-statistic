package net.hemisoft.p2p.converter.plattform.peerberry.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.commons.plattform.writer.AbstractAccountItemWriter
import net.hemisoft.p2p.converter.plattform.peerberry.service.PeerberryAccountImportService

@Slf4j
@Component
public class PeerberryAccountItemWriter extends AbstractAccountItemWriter {
	PeerberryAccountItemWriter(PeerberryAccountImportService service) {
		super(service)
	}
}