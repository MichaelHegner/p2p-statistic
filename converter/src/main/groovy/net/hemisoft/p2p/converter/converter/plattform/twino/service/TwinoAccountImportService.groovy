package net.hemisoft.p2p.converter.converter.plattform.twino.service

import org.springframework.stereotype.Service

import net.hemisoft.p2p.converter.converter.commons.plattform.service.AbstractAccountImportService
import net.hemisoft.p2p.converter.domain.entity.Account

@Service
public class TwinoAccountImportService extends AbstractAccountImportService {
	
	/**
	 * Twino knows only type FUNDING for withdrawal and deposit
	 */
	@Override void increaseAmount(Account account) {
		value += account.amount
	}
	
	@Override void decreaseAmount(Account account) {
		// do nothing
	}
}