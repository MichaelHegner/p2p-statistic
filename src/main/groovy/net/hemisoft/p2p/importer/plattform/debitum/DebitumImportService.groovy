package net.hemisoft.p2p.importer.plattform.debitum

import org.springframework.stereotype.Service

import net.hemisoft.p2p.importer.commons.utils.P2PMapUtils

@Service
public class DebitumImportService {
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
