package net.hemisoft.p2p.converter.converter.plattform.peerberry.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.converter.plattform.peerberry.dto.PeerberryAccountDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractAccountCsvLineMapper

@PackageScope
class _PeerberryAccountCsvLineMapper extends AbstractAccountCsvLineMapper<PeerberryAccountDto> {
	private static final int COL_TRANSFER_TYPE    = ExcelColum.D.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.E.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override PeerberryAccountDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}

	@Override int getTransferTypeColumnIndex()   { COL_TRANSFER_TYPE   }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override PeerberryAccountDto createNewDto() {
		PeerberryAccountDto.newInstance()
	}
}