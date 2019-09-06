package net.hemisoft.p2p.importer.plattform.crowdestate.service

import org.springframework.stereotype.Service

import net.hemisoft.p2p.importer.domain.Account
import net.hemisoft.p2p.importer.domain.TransferType

@Service
public class CrowdestateAccountImportService {
	double value
			
	void saveAccount(List<Account> items) {
		items.each {
			switch(it.transferType) {
				case TransferType.DEPOSIT:  value += it.amount
				                            break
				case TransferType.WITHDRAW: value -= it.amount
				                            break
			}
		}
	}
}
