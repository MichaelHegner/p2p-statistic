package net.hemisoft.p2p.importer.plattform.estateguru.service

import org.springframework.stereotype.Service

import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.TransferType

@Service
public class EstateguruAccountImportService {
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
