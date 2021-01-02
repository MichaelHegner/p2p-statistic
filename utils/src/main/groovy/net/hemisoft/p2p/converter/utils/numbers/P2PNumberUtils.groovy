package net.hemisoft.p2p.converter.utils.numbers

import static org.apache.commons.lang3.StringUtils.deleteWhitespace

import org.apache.commons.lang3.RegExUtils
import org.apache.commons.lang3.math.NumberUtils

final class P2PNumberUtils {
    static Double createDoubleIfPossible(String possibleDouble) {
        if (NumberUtils.isCreatable(possibleDouble)) {
            def result = NumberUtils.createDouble(possibleDouble)
        } else {
            def cleanedInput = cleanInput possibleDouble
            def matcher      = cleanedInput =~ /\d+\.\d{0,2}/
            def found        = matcher.find() ? matcher[0]                : null
            def result       = found != null  ? Double.parseDouble(found) : null 
        }
    }
    
    private static final String cleanInput(possibleDouble) {
        def temp 
        temp = deleteWhitespace possibleDouble
        temp = RegExUtils.replaceAll(temp, "[^0-9?!\\.]", "")
        temp
    }
    
    private P2PNumberUtils() {}
}
