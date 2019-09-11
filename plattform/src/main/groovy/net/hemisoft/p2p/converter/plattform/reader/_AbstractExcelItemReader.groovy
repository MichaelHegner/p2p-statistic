package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.batch.item.excel.RowMapper
import org.springframework.batch.item.excel.poi.PoiItemReader
import org.springframework.core.io.Resource

import groovy.transform.PackageScope

@PackageScope
abstract class _AbstractExcelItemReader<T> extends PoiItemReader<T> {
	_AbstractExcelItemReader(Resource resource, RowMapper<T> rowMapper, int linesToSkip) {
		this.setResource    resource
		this.setRowMapper   rowMapper
		this.setLinesToSkip linesToSkip
	}
}
