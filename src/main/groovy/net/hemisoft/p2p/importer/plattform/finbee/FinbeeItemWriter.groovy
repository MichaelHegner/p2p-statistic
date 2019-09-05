package net.hemisoft.p2p.importer.plattform.finbee

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j

@Slf4j
public class FinbeeItemWriter implements ItemWriter {
	@Autowired FinbeeImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
