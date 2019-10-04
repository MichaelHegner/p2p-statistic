package net.hemisoft.p2p.converter.plattform.service

import static java.math.BigDecimal.ZERO

import java.time.YearMonth

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.TransferType

@Service
class PlattformAccountImportService {
	@Value('${p2p.operation.deposit.abs:true}') boolean useAbsolute
	
	double totalDeposit
	Map<YearMonth, BigDecimal> depositMapByYearMonth = [:]
	
	void saveAccount(List<Account> items) {
		items.each {
			switch(it.transferType) {
				case TransferType.DEPOSIT:  increaseAmount it
											increaseDepositByYearMonth it
				                            break
				case TransferType.WITHDRAW: decreaseAmount it
											decreaseDepositByYearMonth it
				                            break
			}
		}
	}
	
	void increaseAmount(Account account) {
		if(useAbsolute) totalDeposit += Math.abs account.amount
		else            totalDeposit += account.amount
	}
	
	void increaseDepositByYearMonth(Account account) {
		def yearMonth = YearMonth.from account.getIssued()
		depositMapByYearMonth.put(yearMonth, depositMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(account.amount))
	}

	void decreaseAmount(Account account) {
		totalDeposit -= Math.abs account.amount
	}
	
	void decreaseDepositByYearMonth(Account account) {
		def yearMonth = YearMonth.from(account.getIssued())
		depositMapByYearMonth.put(yearMonth, depositMapByYearMonth.getOrDefault(yearMonth, ZERO).minus(account.amount))
	}

}