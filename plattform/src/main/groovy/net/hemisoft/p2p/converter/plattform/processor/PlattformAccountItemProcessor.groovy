package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase
import static org.apache.commons.lang3.StringUtils.isNotBlank

import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.utils.date.P2PDateUtils
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

@Component
class PlattformAccountItemProcessor implements ItemProcessor<AccountDto, Account> {
	@Value('${p2p.plattform:UNKNOWN}')              String plattform
	@Value('${p2p.operation.deposit:DEPOSIT}')      String operationDeposit
	@Value('${p2p.operation.withdrawing:WITHDRAW}') String operationWithdrawing
	
	@Override Account process(AccountDto dto) throws Exception {
		createPopulated dto
	}
	
	Account createPopulated(AccountDto dto) {
		def entity            = Account.newInstance()
		entity.amount         = P2PNumberUtils.createDoubleIfPossible  dto.amount
		entity.issued         = P2PDateUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = Plattform.valueOf plattform.toUpperCase()
		entity.transferType   = createTransferType dto
		entity
	}
	
	private TransferType createTransferType(AccountDto dto) {
		if (isNotBlank(operationDeposit) && containsIgnoreCase(dto.transferType, operationDeposit)) 
			TransferType.DEPOSIT 
		else if (isNotBlank(operationWithdrawing) && containsIgnoreCase(dto.transferType, operationWithdrawing))  
			TransferType.WITHDRAW
		else 
			null 
	}

}