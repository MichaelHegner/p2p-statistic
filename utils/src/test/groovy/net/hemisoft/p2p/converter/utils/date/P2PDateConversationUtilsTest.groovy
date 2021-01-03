package net.hemisoft.p2p.converter.utils.date

import static org.assertj.core.api.Assertions.assertThat

import java.time.LocalDate

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class P2PDateConversationUtilsTest {
    def input, expected
    
    public P2PDateConversationUtilsTest(input, expected) {
        this.input    = input
        this.expected = expected
    }

    @Parameters static cases() {
        [
            // INPUT                    EXPECTED
            [ "2020-01-01 01:01:01",    LocalDate.of(2020, 01, 01) ],
            [ "2020-03-29 02:44:03",    LocalDate.of(2020, 03, 29) ], // Winter- auf Sommerzeit
            
        ]*.toArray()
    }
    
    @Test
    public void test() {
        def result = P2PDateConversionUtils.createLocalDateIfPossible input
        
        if (expected != null) assertThat(result).isEqualTo(expected)
        else                  assertThat(result).isNull()
    }
}
