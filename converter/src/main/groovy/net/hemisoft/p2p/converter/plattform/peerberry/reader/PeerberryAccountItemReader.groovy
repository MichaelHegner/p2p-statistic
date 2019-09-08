package net.hemisoft.p2p.converter.plattform.peerberry.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class PeerberryAccountItemReader extends _PeerberryAbstractItemReader {
	public PeerberryAccountItemReader(Resource peerberryResource) {
		super(peerberryResource)
		this.lineMapper = _PeerberryAccountCsvLineMapper.newInstance()
	}
}
