package net.hemisoft.p2p.converter.utils.date

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

import org.apache.commons.lang3.math.NumberUtils
import org.apache.commons.lang3.time.DateUtils
import org.apache.commons.validator.GenericValidator

final class P2PDateUtils {
	static final String DEFAULT_PATTERN = "yyyy-MM-dd"
	
	
	static LocalDate createLocalDateIfPossible(def possibleDate) {
		LocalDate resultDate = null
		
		if (null == resultDate) {
			resultDate = createByNumberIfPossible possibleDate
		}

		if (null == resultDate) {
			resultDate = createByPatternIfPossible possibleDate
		}		
		
		if (null == resultDate) {
			resultDate = createByRegexIfPossible possibleDate
		}
		
		resultDate
	}
	
	// NUMBER ...
	
	static LocalDate createByNumberIfPossible(possibleDate) {
		if(NumberUtils.isCreatable(possibleDate)) {
			def number = NumberUtils.toLong possibleDate
			return Instant.ofEpochSecond(number)
			    .atZone(ZoneId.systemDefault()).toLocalDate()
		} else {
			return null
		}
	}
	
	// PATTERN ...
	
	static LocalDate createByPatternIfPossible(possibleDate) {
		Optional pattern = getValidDatePattern(possibleDate)
		if(pattern.isPresent()) {
			return DateUtils.parseDate(possibleDate, pattern.get())
				.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate()
		} else {
			return null
		}
	}
	
	static Optional getValidDatePattern(def possibleDate) {
		def validPatterns = [
			"dd.MM.yyyy", "dd.MM.yyyy HH:mm", "dd.MM.yyyy HH:mm:ss", 
			"dd.MM.yy",   "dd.MM.yy HH:mm",   "dd.MM.yy HH:mm:ss", 
			"dd/MM/yyyy", "dd/MM/yyyy HH:mm", "dd/MM/yyyy HH:mm:ss", 
			"yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss"
		]
		for (pattern in validPatterns) {
			if(GenericValidator.isDate(possibleDate, pattern, true)) {
				return Optional.of(pattern)
			}
		}
		
		return Optional.empty()
	}
	
	// REGEX ...
	
	static LocalDate createByRegexIfPossible(possibleDate) {
		def matcher = possibleDate =~ /\d{2}\/\d{2}\/\d{4}/
		createByPatternIfPossible ( matcher.find() ? matcher[0] : null )
	}
	
	private P2PDateUtils() {}
}
