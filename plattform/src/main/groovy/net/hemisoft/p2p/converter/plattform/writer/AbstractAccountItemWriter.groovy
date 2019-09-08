package net.hemisoft.p2p.converter.plattform.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import net.hemisoft.p2p.converter.plattform.service.AbstractAccountImportService

abstract class AbstractAccountItemWriter implements ItemWriter {
	AbstractAccountImportService service
	
	AbstractAccountItemWriter(AbstractAccountImportService service) {
		this.service = service
	}
	
	@Override void write(List items) throws Exception {
		service.saveAccount items
	}
}
