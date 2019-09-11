package net.hemisoft.p2p.converter.plattform.reader

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.LineMapper
import org.springframework.core.io.Resource

import groovy.transform.PackageScope

@PackageScope
abstract class _AbstractCsvItemReader<T> extends FlatFileItemReader<T> {
	_AbstractCsvItemReader(Resource resource, LineMapper<T> lineMapper, int linesToSkip) {
		this.setResource    resource
		this.setLineMapper  lineMapper
		this.setLinesToSkip linesToSkip
	}
}
