package net.hemisoft.p2p.converter.plattform.peerberry.reader

import groovy.transform.PackageScope
import net.hemisoft.p2p.converter.plattform.dto.AbstractLoanDto
import net.hemisoft.p2p.converter.plattform.key.ExcelColum
import net.hemisoft.p2p.converter.plattform.mapper.AbstractLoanCsvLineMapper
import net.hemisoft.p2p.converter.plattform.peerberry.dto.PeerberryLoanDto

@PackageScope
class _PeerberryLoanCsvLineMapper extends AbstractLoanCsvLineMapper<PeerberryLoanDto> {
	private static final int COL_TRANSACTION_ID   = ExcelColum.A.ordinal()
	private static final int COL_LOAN_ID          = ExcelColum.C.ordinal()
	private static final int COL_INVESTED_AMOUNT  = ExcelColum.D.ordinal()
	private static final int COL_ISSUED           = ExcelColum.B.ordinal()
	
	@Override
	PeerberryLoanDto mapLine(String line, int lineNumber) throws Exception {
		super.mapLine(line, lineNumber)
	}
	
	@Override int getLoanIdColumnIndex()         { COL_LOAN_ID         }
	@Override int getInvestedAmountColumnIndex() { COL_INVESTED_AMOUNT }
	@Override int getIssuedColumnIndex()         { COL_ISSUED          }
	
	@Override AbstractLoanDto createNewDto() {
		PeerberryLoanDto.newInstance()
	}
}
