package net.hemisoft.p2p.importer.plattform.robocash

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j

@Slf4j
public class RobocashItemWriter implements ItemWriter {
	@Autowired RobocashImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
