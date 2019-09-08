package net.hemisoft.p2p.converter.converter.plattform.peerberry.writer

import org.springframework.stereotype.Component

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.converter.converter.plattform.peerberry.service.PeerberryAccountImportService
import net.hemisoft.p2p.converter.plattform.writer.AbstractAccountItemWriter

@Slf4j
@Component
public class PeerberryAccountItemWriter extends AbstractAccountItemWriter {
	PeerberryAccountItemWriter(PeerberryAccountImportService service) {
		super(service)
	}
}