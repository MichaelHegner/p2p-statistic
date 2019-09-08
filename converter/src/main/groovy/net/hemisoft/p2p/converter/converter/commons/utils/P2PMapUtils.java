package net.hemisoft.p2p.converter.converter.commons.utils;

import static lombok.AccessLevel.PRIVATE;

import java.util.Map;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public final class P2PMapUtils {
	static void increment(Map<String, Integer> map, String key) {
		if(map.computeIfPresent(key, (k, v) -> v + 1) == null) {
			map.put(key, 1);
		}
	}
}
