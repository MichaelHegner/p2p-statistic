package net.hemisoft.p2p.importer.flender

import org.springframework.batch.item.file.LineMapper

class FlenderCsvRowMapper implements LineMapper<FlenderTransactionDto> {
	private static final String SEPARATOR = ","
	private static final int COL_ID = 0
	private static final int COL_INVESTMENT_VALUE = 1

	@Override
	FlenderTransactionDto mapLine(String line, int lineNumber) throws Exception {
		def columns = line.split(SEPARATOR)
		def dto = FlenderTransactionDto.newInstance()
		dto.ID = columns[COL_ID]
		dto.investedAmount = columns[COL_INVESTMENT_VALUE]
		dto
	}

}
