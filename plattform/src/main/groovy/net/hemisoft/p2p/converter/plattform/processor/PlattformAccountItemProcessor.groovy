package net.hemisoft.p2p.converter.plattform.processor

import static org.apache.commons.lang3.StringUtils.endsWithIgnoreCase
import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase

import javax.validation.Validation

import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.Account
import net.hemisoft.p2p.converter.domain.entity.Plattform
import net.hemisoft.p2p.converter.domain.entity.TransferType
import net.hemisoft.p2p.converter.plattform.dto.AccountDto
import net.hemisoft.p2p.converter.utils.date.P2PDateConversionUtils
import net.hemisoft.p2p.converter.utils.numbers.P2PNumberUtils

@Component
class PlattformAccountItemProcessor implements ItemProcessor<AccountDto, Account> {
    @Value('${p2p.plattform:UNKNOWN}')               String       plattform
    @Value('${p2p.operation.deposit:DEPOSIT}')       List<String> operationDeposit
    @Value('${p2p.operation.withdrawing:WITHDRAW}')  List<String> operationWithdrawing
    @Value('${p2p.operation.investment:INVESTMENT}') List<String> operationInvestment
    @Value('${p2p.operation.principal:PRINCIPAL}')   List<String> operationPrincipal
    @Value('${p2p.operation.earning:PRINCIPAL}')     List<String> operationEarning
    
    
    def validator = Validation.buildDefaultValidatorFactory().getValidator()
    
    @Override Account process(AccountDto dto) throws Exception {
        validator.validate(dto).isEmpty() 
            ? createPopulated(dto) 
            : null  
    }
    
    Account createPopulated(AccountDto dto) {
        def entity            = Account.newInstance()
        entity.transferType   = createTransferType dto
        entity.amount         = P2PNumberUtils.createDoubleIfPossible  dto.amount
        entity.issued         = P2PDateConversionUtils.createLocalDateIfPossible dto.issuedDate
        entity.plattform      = Plattform.valueOf plattform.toUpperCase()
        entity
    }
    
    private TransferType createTransferType(AccountDto dto) {
        if      (checkOperation(dto, operationDeposit))      TransferType.DEPOSIT 
        else if (checkOperation(dto, operationWithdrawing))  TransferType.WITHDRAW
        else if (checkOperation(dto, operationInvestment))   TransferType.INVESTMENT
        else if (checkOperation(dto, operationPrincipal))    TransferType.PRINCIPAL
        else if (checkOperation(dto, operationEarning))      TransferType.EARNING
        else                                                 null 
    }
    
    private boolean checkOperation(AccountDto dto, List<String> operations) {
        boolean check = false
        check |= operations.stream().anyMatch{s -> startsWithIgnoreCase(dto.transferType, s)}
        check |= operations.stream().anyMatch{s -> endsWithIgnoreCase(dto.transferType, s)}
        check
    }

}