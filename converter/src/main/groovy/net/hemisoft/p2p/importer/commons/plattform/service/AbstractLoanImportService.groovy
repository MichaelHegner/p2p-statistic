package net.hemisoft.p2p.importer.commons.plattform.service

import net.hemisoft.p2p.importer.commons.utils.P2PMapUtils

public abstract class AbstractLoanImportService {
	def loanCounter = [:]
	
	void saveLoans(List items) {
		items.each {
			P2PMapUtils.increment loanCounter, it.loanId
		}
	}
	
	int countLoans() {
		loanCounter.size()
	}
}
