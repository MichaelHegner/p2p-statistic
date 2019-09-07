package net.hemisoft.p2p.importer.plattform.flender.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class FlenderAccountItemReader extends _FlenderAbstractItemReader {
	public FlenderAccountItemReader(Resource flenderAccountResource) {
		super(flenderAccountResource)
		this.lineMapper = _FlenderAccountCsvRowMapper.newInstance()
	}
}