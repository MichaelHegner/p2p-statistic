package net.hemisoft.p2p.importer.plattform.flender.reader

import org.springframework.core.io.Resource

class FlenderAccountItemReader extends _FlenderAbstractItemReader {
	public FlenderAccountItemReader(Resource flenderAccountResource) {
		super(flenderAccountResource)
		this.lineMapper = _FlenderAccountCsvRowMapper.newInstance()
	}
}