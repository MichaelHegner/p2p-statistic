package net.hemisoft.p2p.importer.crowdestate

import org.springframework.batch.item.ItemWriter

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.domain.TransactionEntity

@Slf4j
public class CrowdestateItemWriter implements ItemWriter<TransactionEntity> {

	@Override
	public void write(List<TransactionEntity> items) throws Exception {
		items.each { log.info it.toString() }
	}

}
