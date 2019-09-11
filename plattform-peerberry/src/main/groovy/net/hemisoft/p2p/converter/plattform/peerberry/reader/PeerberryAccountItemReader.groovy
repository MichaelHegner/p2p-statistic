package net.hemisoft.p2p.converter.plattform.peerberry.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryAccountDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractAccountCsvItemReader

@Component
class PeerberryAccountItemReader extends AbstractAccountCsvItemReader<PeerberryAccountDto> {
	private static final int LINES_TO_SKIP = 1
	
	public PeerberryAccountItemReader(Resource resource, PeerberryAccountCsvLineMapper lineMapper) {
		super(resource, lineMapper, LINES_TO_SKIP)
	}
}
