package net.hemisoft.p2p.importer.plattform.bondora

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

public class BondoraItemWriter implements ItemWriter {
	@Autowired BondoraImportService service
	
	@Override void write(List items) throws Exception {
		service.saveLoans items
	}
}
