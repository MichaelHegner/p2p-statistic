package net.hemisoft.p2p.converter.plattform.peerberry.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.commons.key.ExcelColum
import net.hemisoft.p2p.converter.commons.plattform.AbstractAccountCsvLineMapper
import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryAccountDto

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