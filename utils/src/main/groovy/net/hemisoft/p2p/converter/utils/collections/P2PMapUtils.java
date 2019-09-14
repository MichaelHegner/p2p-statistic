package net.hemisoft.p2p.converter.utils.collections;

import java.util.Map;

public final class P2PMapUtils {
	static void increment(Map<String, Integer> map, String key) {
		if(map.computeIfPresent(key, (k, v) -> v + 1) == null) {
			map.put(key, 1);
		}
	}
	
	private P2PMapUtils() {}
}
