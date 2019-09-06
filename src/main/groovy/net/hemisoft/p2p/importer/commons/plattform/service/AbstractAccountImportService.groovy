package net.hemisoft.p2p.importer.commons.plattform.service

import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.TransferType

abstract class AbstractAccountImportService {
	double value
	
	void saveAccount(List<Account> items) {
		items.each {
			switch(it.transferType) {
				case TransferType.DEPOSIT:  value += Math.abs it.amount
				                            break
				case TransferType.WITHDRAW: value -= Math.abs it.amount
				                            break
			}
		}
	}
}
