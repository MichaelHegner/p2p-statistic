package net.hemisoft.p2p.importer.commons.plattform.service

import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.TransferType

abstract class AbstractAccountImportService {
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
		value += Math.abs account.amount
	}

	void decreaseAmount(Account account) {
		value -= Math.abs account.amount
	}
}
