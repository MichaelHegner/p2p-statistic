package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.endsWithIgnoreCase
import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.exception.TransferStatusException

@Component
public class PlattformAccountTransferStatusFilterProcessor implements ItemFilterProcessor {
	
	@Value('${p2p.filter.transfer.status:#{null}}')
	List<String> transferStatus
	
	@Override
	public AccountDto process(AccountDto item) throws Exception {
		if (null == transferStatus || checkOperationTransferStatus(item, transferStatus)) {
			return item
		} else {
			throw new TransferStatusException()
		}
	}
	
    // TODO: #25 - Use Mapstruct
	private boolean checkOperationTransferStatus(AccountDto dto, List<String> status) {
		boolean check = false
		check |= status.stream().anyMatch{s -> startsWithIgnoreCase(dto.transferStatus, s)}
		check |= status.stream().anyMatch{s -> endsWithIgnoreCase(dto.transferStatus, s)}
		check
	}

}
