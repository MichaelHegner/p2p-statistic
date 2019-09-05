package net.hemisoft.p2p.importer.plattform.grupeer

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j

@Slf4j
public class GrupeerItemWriter implements ItemWriter {
	@Autowired GrupeerImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
