package net.hemisoft.p2p.importer.plattform.crowdestate.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.crowdestate.service.CrowdestateLoanImportService

@Slf4j
public class CrowdestateLoanItemWriter implements ItemWriter {
	@Autowired CrowdestateLoanImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}