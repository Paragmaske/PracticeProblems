package RateLimiter;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public class RateLimiter {

	static Map<Integer, Pair<Integer, Long>> userWiseHitTracker = new HashMap<>();

	boolean hitEndPoint(int customerId) {
		if (!userWiseHitTracker.containsKey(customerId)) {

			Pair<Integer, Long> userHitByTimeMap = Pair.of(RateLimiterConfig.requests - 1,
					System.currentTimeMillis() + RateLimiterConfig.timeInMillis);
			userWiseHitTracker.put(customerId, userHitByTimeMap);
			return true;
		} else {

			Pair<Integer, Long> pair = userWiseHitTracker.get(customerId);
			if (userWiseHitTracker.get(customerId).getKey() > 0) {
				userWiseHitTracker.put(customerId, Pair.of(pair.getKey() - 1, pair.getValue()));
			return true;
			} else {
				if (System.currentTimeMillis() > userWiseHitTracker.get(customerId).getValue()) {
					Pair<Integer, Long> userHitByTimeMap = Pair.of(RateLimiterConfig.requests - 1,
							System.currentTimeMillis() + RateLimiterConfig.timeInMillis);
					userWiseHitTracker.put(customerId, userHitByTimeMap);
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
