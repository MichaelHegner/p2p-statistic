package net.hemisoft.p2p.importer.plattform.peerberry

import org.springframework.batch.item.ItemWriter

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.domain.TransactionEntity

@Slf4j
public class PeerberryItemWriter implements ItemWriter<TransactionEntity> {

	@Override
	public void write(List<TransactionEntity> items) throws Exception {
		items.each { log.info it.toString() }
	}

}
