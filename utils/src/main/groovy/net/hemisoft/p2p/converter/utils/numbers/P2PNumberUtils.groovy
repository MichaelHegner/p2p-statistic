package net.hemisoft.p2p.converter.utils.numbers

import static org.apache.commons.lang3.StringUtils.deleteWhitespace

import java.util.regex.Matcher

class P2PNumberUtils {
	static Double createDoubleIfPossible(String possibleDouble) {
		def matcher = deleteWhitespace(possibleDouble) =~ /\d{1,8}.\d{1,2}?/
		assert matcher instanceof Matcher
		matcher.find() ? Double.parseDouble(matcher[0]) : null 
	}
	
	private P2PNumberUtils() {}
}
