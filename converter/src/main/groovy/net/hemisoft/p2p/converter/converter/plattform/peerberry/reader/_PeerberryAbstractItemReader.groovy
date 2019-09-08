package net.hemisoft.p2p.converter.converter.plattform.peerberry.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.peerberry.dto.PeerberryLoanDto

@PackageScope
abstract class _PeerberryAbstractItemReader extends FlatFileItemReader<PeerberryLoanDto> {
	private static final int LINES_TO_SKIP = 1

	_PeerberryAbstractItemReader(Resource mintosResource) {
		this.linesToSkip = LINES_TO_SKIP
		this.resource    = mintosResource
	}
}