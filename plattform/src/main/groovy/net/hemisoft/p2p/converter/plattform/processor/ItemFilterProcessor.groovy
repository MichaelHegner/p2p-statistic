package net.hemisoft.p2p.converter.plattform.processor

import org.springframework.batch.item.ItemProcessor

import net.hemisoft.p2p.converter.plattform.dto.AccountDto

public interface ItemFilterProcessor extends ItemProcessor<AccountDto, AccountDto> {}