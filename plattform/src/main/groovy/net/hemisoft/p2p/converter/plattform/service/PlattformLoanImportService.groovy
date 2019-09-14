package net.hemisoft.p2p.converter.plattform.service

import org.springframework.stereotype.Service

import net.hemisoft.p2p.converter.utils.collections.P2PMapUtils

@Service
class PlattformLoanImportService {
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