package net.hemisoft.p2p.importer.neofinance

import org.springframework.batch.item.file.LineMapper

class NeofinanceCsvRowMapper implements LineMapper<NeofinanceTransactionDto> {
	private static final String SEPARATOR = ","
	private static final int COL_ID = 0
	private static final int COL_INVESTMENT_VALUE = 5

	@Override
	NeofinanceTransactionDto mapLine(String line, int lineNumber) throws Exception {
		def columns = line.replace("\"", "").split(SEPARATOR)
		def dto = NeofinanceTransactionDto.newInstance()
		dto.ID = columns[COL_ID]
		dto.investedAmount = columns[COL_INVESTMENT_VALUE]
		dto
	}

}
