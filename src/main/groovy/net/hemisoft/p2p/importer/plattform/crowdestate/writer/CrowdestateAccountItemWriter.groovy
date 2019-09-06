package net.hemisoft.p2p.importer.plattform.crowdestate.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateAccountImportService

@Slf4j
public class CrowdestateAccountItemWriter implements ItemWriter {
	@Autowired CrowdestateAccountImportService service
	
	@Override void write(List items) throws Exception {
		service.saveAccount items
	}
}
