package net.hemisoft.p2p.converter.utils.numbers

import org.apache.commons.lang3.RegExUtils
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils


// TODO: Maybe define Number Converter for each plattform.
final class P2PNumberUtils {
    
    
    static Double createDoubleIfPossible(String possibleDouble) {
        
        if (NumberUtils.isCreatable(possibleDouble)) {
            return NumberUtils.createDouble(possibleDouble)
        } 
        
        def temp 
        temp = StringUtils.deleteWhitespace possibleDouble
        temp = RegExUtils.replaceAll(temp, "[^0-9?!\\.,]", "")
        
        if (findWithDecimalPoint(temp).isPresent()) {
            temp = RegExUtils.replaceAll(temp, "[^0-9?!\\.]", "")
            return Double.parseDouble( findWithDecimalPoint(temp).get() )
        }
        
        if (findWithDecimalComma(temp).isPresent()) {
            temp = RegExUtils.replaceAll(temp, "[^0-9?!\\,]", "")
            temp = RegExUtils.replaceAll(temp, "[,]", ".")
            return Double.parseDouble(temp)
        }
        
        return null
    }
    
    
    private static Optional<String> findWithDecimalPoint(String possibleDouble) {
        def matcher = possibleDouble =~ /\d+\.\d{0,2}/
            matcher.find() 
            ? Optional.of(matcher[0])
            : Optional.empty()
    }
    
    private static Optional<String> findWithDecimalComma(String possibleDouble) {
        def matcher = possibleDouble =~ /\d+,\d{0,2}/
            matcher.find() 
            ? Optional.of(matcher[0])
            : Optional.empty()
    }
    
    
    private P2PNumberUtils() {}
}
