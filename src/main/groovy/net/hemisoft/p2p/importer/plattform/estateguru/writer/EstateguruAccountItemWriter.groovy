package net.hemisoft.p2p.importer.plattform.estateguru.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired

import groovy.util.logging.Slf4j
import net.hemisoft.p2p.importer.plattform.estateguru.service.EstateguruAccountImportService

@Slf4j
public class EstateguruAccountItemWriter implements ItemWriter {
	@Autowired EstateguruAccountImportService service
	
	@Override void write(List items) throws Exception {
		service.saveAccount items
	}
}
