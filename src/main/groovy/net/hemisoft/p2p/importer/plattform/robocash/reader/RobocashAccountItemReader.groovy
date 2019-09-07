package net.hemisoft.p2p.importer.plattform.robocash.reader

import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class RobocashAccountItemReader extends _RobocashAbstractItemReader {
	public RobocashAccountItemReader(Resource robocashResource) {
		super(robocashResource)
		this.rowMapper = _RobocashAccountExcelRowMapper.newInstance()
	}
}