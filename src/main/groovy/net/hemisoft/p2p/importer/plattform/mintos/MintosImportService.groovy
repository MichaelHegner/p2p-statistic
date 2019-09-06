package net.hemisoft.p2p.importer.plattform.mintos

import org.springframework.stereotype.Service

import net.hemisoft.p2p.importer.commons.utils.P2PMapUtils

@Service
public class MintosImportService {
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