package net.hemisoft.p2p.converter.plattform.processor

import org.apache.commons.lang3.BooleanUtils
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.exception.TransferStatusException

@Component
public class PlattformAccountTransferTypeFilterProcessor implements ItemFilterProcessor {
	
	@Value('${p2p.filter.transfer.type:#{null}}')
	List<String> transferTypes
	
	@Override
	public AccountDto process(AccountDto item) throws Exception {
		if (null == transferTypes || checkOperationTransferStatus(item, transferTypes)) {
			return item
		} else {
			throw new TransferStatusException()
		}
	}
	
	private boolean checkOperationTransferStatus(AccountDto dto, List<String> invalidElementList) {
		def invalidElementsInList = invalidElementList.stream().anyMatch{s -> StringUtils.equalsIgnoreCase(dto.transferType, s)}
		return BooleanUtils.negate(invalidElementsInList)
	}

}
