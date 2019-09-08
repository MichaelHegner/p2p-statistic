package net.hemisoft.p2p.converter.plattform.peerberry.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class PeerberryLoanItemReader extends _PeerberryAbstractItemReader {
	public PeerberryLoanItemReader(Resource peerberryResource) {
		super(peerberryResource)
		this.lineMapper = _PeerberryLoanCsvLineMapper.newInstance()
	}
}
