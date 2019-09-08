package net.hemisoft.p2p.converter.commons.utils

import org.apache.commons.lang3.math.NumberUtils

class P2PNumberUtils {
	static Double createDoubleIfPossible(String possibleDouble) {
		NumberUtils.isCreatable(possibleDouble) ? Double.parseDouble(possibleDouble) : null
	}
}
