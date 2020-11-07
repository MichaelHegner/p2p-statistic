package net.hemisoft.p2p.converter.plattform.writer

import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component

import net.hemisoft.p2p.converter.plattform.service.PlattformAccountImportService

@Component
class PlattformAccountItemWriter implements ItemWriter {
    final PlattformAccountImportService service
    
    PlattformAccountItemWriter(PlattformAccountImportService plattformAccountImportService) {
        this.service = plattformAccountImportService
    }
    
    @Override void write(List items) throws Exception {
        service.saveAccount items
    }
}