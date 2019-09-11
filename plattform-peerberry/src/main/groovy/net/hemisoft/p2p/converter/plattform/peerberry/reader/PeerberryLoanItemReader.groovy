package net.hemisoft.p2p.converter.plattform.peerberry.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryLoanDto
import net.hemisoft.p2p.converter.plattform.reader.AbstractLoanCsvItemReader

@Component
class PeerberryLoanItemReader extends AbstractLoanCsvItemReader<PeerberryLoanDto> {
	private static final int LINES_TO_SKIP = 1
	
	public PeerberryLoanItemReader(Resource resource, PeerberryLoanCsvLineMapper lineMapper) {
		super(resource, lineMapper, LINES_TO_SKIP)
	}
}
