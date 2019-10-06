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
	double totalWithdrawal
	double totalInvestment
	double totalPrincipal
	double totalEarning
	
	Map<YearMonth, BigDecimal> depositMapByYearMonth = [:]
	Map<YearMonth, BigDecimal> withdrawalMapByYearMonth = [:]
	Map<YearMonth, BigDecimal> investmentMapByYearMonth = [:]
	Map<YearMonth, BigDecimal> principleMapByYearMonth = [:]
	Map<YearMonth, BigDecimal> earningMapByYearMonth = [:]
	
	void saveAccount(List<Account> items) {
		items.each {
			switch(it.transferType) {
				case TransferType.DEPOSIT:    increaseDeposit it
											  increaseDepositByYearMonth it
				                              break
				case TransferType.WITHDRAW:   increaseWithdrawal it
											  increaseWithdrawalByYearMonth it
				                              break
				case TransferType.INVESTMENT: increaseInvestment it
											  increaseInvestmentByYearMonth it
											  break
				case TransferType.PRINCIPAL:  increasePrincipal it
											  increasePrincipalByYearMonth it
											  break
				case TransferType.EARNING: 	  increaseEarning it
											  increaseEarningByYearMonth it
											  break
				case TransferType.DEFICIT: 	  decreaseEarning it
											  decreaseEarningByYearMonth it
											  break
			}
		}
	}
	
	
	void increaseDeposit(Account account) {
		if(useAbsolute) totalDeposit += Math.abs account.amount
		else            totalDeposit += account.amount
	}
	
	void increaseDepositByYearMonth(Account account) {
		def yearMonth = YearMonth.from account.getIssued()
		depositMapByYearMonth.put(yearMonth, depositMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(account.amount))
	}

	void increaseWithdrawal(Account account) {
		totalWithdrawal += Math.abs account.amount
	}
	
	void increaseWithdrawalByYearMonth(Account account) {
		def yearMonth = YearMonth.from(account.getIssued())
		withdrawalMapByYearMonth.put(yearMonth, withdrawalMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(account.amount))
	}
	
	
	void increaseInvestment(Account account) {
		if(useAbsolute) totalInvestment += Math.abs account.amount
		else            totalInvestment += account.amount
	}
	
	void increaseInvestmentByYearMonth(Account account) {
		def yearMonth = YearMonth.from account.getIssued()
		def accountAmount = useAbsolute ? Math.abs(account.amount) : account.amount
		investmentMapByYearMonth.put(yearMonth, investmentMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(accountAmount))
	}

	void increasePrincipal(Account account) {
		totalPrincipal += Math.abs account.amount
	}
	
	void increasePrincipalByYearMonth(Account account) {
		def yearMonth = YearMonth.from(account.getIssued())
		principleMapByYearMonth.put(yearMonth, principleMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(account.amount))
	}

	
	void increaseEarning(Account account) {
		if(useAbsolute) totalEarning += Math.abs account.amount
		else            totalEarning += account.amount
	}
	
	void increaseEarningByYearMonth(Account account) {
		def yearMonth = YearMonth.from account.getIssued()
		def accountAmount = Math.abs account.amount
		earningMapByYearMonth.put(yearMonth, earningMapByYearMonth.getOrDefault(yearMonth, ZERO).plus(accountAmount))
	}

	void decreaseEarning(Account account) {
		totalEarning -= Math.abs account.amount
	}
	
	void decreaseEarningByYearMonth(Account account) {
		def yearMonth = YearMonth.from(account.getIssued())
		earningMapByYearMonth.put(yearMonth, earningMapByYearMonth.getOrDefault(yearMonth, ZERO).minus(account.amount))
	}

}