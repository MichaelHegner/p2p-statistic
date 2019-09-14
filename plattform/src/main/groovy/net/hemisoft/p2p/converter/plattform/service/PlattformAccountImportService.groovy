package net.hemisoft.p2p.converter.plattform.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Service
class PlattformAccountImportService {
	@Value('${p2p.operation.deposit.abs:true}') boolean useAbsolute
	
	double value
	
	void saveAccount(List<Account> items) {
		items.each {
			switch(it.transferType) {
				case TransferType.DEPOSIT:  increaseAmount it
				                            break
				case TransferType.WITHDRAW: decreaseAmount it
				                            break
			}
		}
	}
	
	void increaseAmount(Account account) {
		if(useAbsolute) value += Math.abs account.amount
		else            value += account.amount
	}

	void decreaseAmount(Account account) {
		value -= Math.abs account.amount
	}
}