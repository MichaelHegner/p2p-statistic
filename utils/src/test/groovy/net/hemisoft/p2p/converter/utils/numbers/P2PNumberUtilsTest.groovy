package net.hemisoft.p2p.converter.utils.numbers

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.offset

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class P2PNumberUtilsTest {
    def input, expected
    
    public P2PNumberUtilsTest(input, expected) {
        this.input    = input
        this.expected = expected
    }

    @Parameters static cases() {
        [
            // INPUT            EXPECTED
            [ "+0.50€",         0.5d ],
            [ "-0.50€",         0.5d ], // does absolut number // TODO: Think about it
            [ "+1,500.00€",     1500d ],
            [ "+1, 500.00â‚¬",  1500d ],
            [ "abc",            null ],
            [ "",               null ],
            [ null,             null ],
            
        ]*.toArray()
    }
    
    @Test
    public void test() {
        def result = P2PNumberUtils.createDoubleIfPossible input
        
        if (expected != null) assertThat(result).isCloseTo(expected, offset(0.001d))
        else                  assertThat(result).isNull()
    }
}
