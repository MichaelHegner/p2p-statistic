package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.endsWithIgnoreCase
import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.plattform.exception.TransferStatusException

@Component
public class PortfolioPerformanceTransferStatusFilterProcessor implements ItemFilterProcessor {

    @Value('${p2p.operation.investment}')
    List<String> investmentStatus
	
    @Value('${p2p.operation.principal}')
    List<String> principalStatus
    
	@Override
	public AccountDto process(AccountDto item) throws Exception {
		if (null == investmentStatus || checkOperationTransferStatus(item, investmentStatus)) {
		    throw new TransferStatusException()
		}

        if (null == principalStatus || checkOperationTransferStatus(item, principalStatus)) {
		    throw new TransferStatusException()
		}
         
		return item
	}
	
    // TODO: #25 - Use Mapstruct
	private boolean checkOperationTransferStatus(AccountDto dto, List<String> status) {
		boolean check = false
		check |= status.stream().anyMatch{s -> startsWithIgnoreCase(dto.transferType, s)}
		check |= status.stream().anyMatch{s -> endsWithIgnoreCase(dto.transferType, s)}
		check
	}

}
