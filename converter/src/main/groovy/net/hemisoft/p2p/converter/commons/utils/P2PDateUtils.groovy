package net.hemisoft.p2p.converter.commons.utils

import java.time.LocalDate
import java.time.ZoneId

import org.apache.commons.lang3.time.DateUtils
import org.apache.commons.validator.GenericValidator

public class P2PDateUtils {
	static String[] validPatterns = [
		"dd.MM.yyyy", "dd.MM.yy HH:mm:ss", "dd/MM/yyyy", "dd/MM/yyyy HH:mm", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"
	]
	
	static LocalDate createLocalDateIfPossible(def possibleDate) {
		Optional pattern = getValidDatePattern(possibleDate)
		if(pattern.isPresent())
			DateUtils.parseDate(possibleDate, pattern.get())
				.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate()
		else null
	}
	
	static Optional getValidDatePattern(def possibleDate) {
		for (pattern in validPatterns) {
			if(GenericValidator.isDate(possibleDate, pattern, true)) {
				return Optional.of(pattern)
			}
		}
		
		return Optional.empty()
	}
}
