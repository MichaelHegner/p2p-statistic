package net.hemisoft.p2p.converter.converter.commons.plattform.service

import net.hemisoft.p2p.converter.converter.commons.utils.P2PMapUtils

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
