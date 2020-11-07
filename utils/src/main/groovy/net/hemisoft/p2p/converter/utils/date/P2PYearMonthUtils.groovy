package net.hemisoft.p2p.converter.utils.date

import java.time.YearMonth

final class P2PYearMonthUtils {

    private P2PYearMonthUtils() {}
    
    static YearMonth findFirstYearMonth(List<YearMonth> yearMonths, List<YearMonth> searchArea) {
        yearMonths.stream()
            .filter{containAnyMapYearMonth(it, searchArea)}
            .findFirst()
    }
    
    static void containAnyMapYearMonth(YearMonth yearMonth, List<YearMonth> searchArea) {
        boolean contains = false
        
        for(Map<YearMonth, Object> map : searchArea) {
            contains  = map.containsKey yearMonth
        }
        
        contains
    }
}
