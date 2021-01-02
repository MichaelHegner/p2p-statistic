package net.hemisoft.p2p.converter.plattform.mapper


import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.domain.entity.TransferType

// TODO: #25 - Use Mapstruct
@Component
public class PortfolioPerformanceTransferTypeMapper {

    public static String map(TransferType transferType) {
        switch(transferType) {
            case TransferType.DEFICIT:    return "Gebühren"
            case TransferType.DEPOSIT:    return "Einlage"
            case TransferType.EARNING:    return "Zinsen"
            case TransferType.WITHDRAW:   return "Entnahme" 
            default:
                throw IllegalArgumentException.newInstance("Invalid transfer type: " + transferType)
        }
    }
}
