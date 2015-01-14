package leetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new LinkedList<Interval>();
		if (intervals != null && intervals.size() > 0) {
			Map<Double, Interval> intervalMap = new TreeMap<Double, Interval>();
			for (int i = 0; i < intervals.size(); i++) {
				Interval interval = intervals.get(i);
				intervalMap.put(
						Double.valueOf(interval.start + "." + interval.end),
						interval);
			}
			Iterator<Interval> iterator = intervalMap.values().iterator();
			Interval preInterval = iterator.next();
			while (iterator.hasNext()) {
				Interval interval = (Interval) iterator.next();
				if (preInterval.end >= interval.start) {
					preInterval.end = Math.max(preInterval.end, interval.end);
				} else {
					result.add(preInterval);
					preInterval = interval;
				}
			}
			result.add(preInterval);
		}
		return result;
	}
}
