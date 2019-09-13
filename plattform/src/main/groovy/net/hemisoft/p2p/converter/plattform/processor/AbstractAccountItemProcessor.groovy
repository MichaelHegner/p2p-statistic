package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase

import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.dto.AbstractAccountDto
import net.hemisoft.p2p.converter.utils.date.P2PDateUtils
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

public abstract class AbstractAccountItemProcessor<I extends AbstractAccountDto, O extends Account> implements ItemProcessor<I, O> {

	@Value('${p2p.operation.deposit}')     private String operationDeposit
	@Value('${p2p.operation.withdrawing}') private String operationWithdrawing
	
	@Override O process(I dto) throws Exception {
		createPopulated dto
	}
	
	O createPopulated(I dto) {
		def entity            = Account.newInstance()
		entity.amount         = P2PNumberUtils.createDoubleIfPossible  dto.amount
		entity.issued         = P2PDateUtils.createLocalDateIfPossible dto.issuedDate
		entity.plattform      = createPlattform()
		entity.transferType   = createTransferType dto
		entity
	}
	
	private TransferType createTransferType(I dto) {
		if (containsIgnoreCase(dto.transferType, operationDeposit)) 
			TransferType.DEPOSIT 
		else if (containsIgnoreCase(dto.transferType, operationWithdrawing))  
			TransferType.WITHDRAW
		else 
			null 
	}

	abstract Plattform createPlattform()
}
