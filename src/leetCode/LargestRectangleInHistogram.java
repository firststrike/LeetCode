package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] height) {
		// 计数表<高度,数量>，当出现断档时归0
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		// 最大次数计数表<高度,连续出现的最大次数>
		Map<Integer, Integer> maximumMap = new HashMap<Integer, Integer>();
		// 初始化两个计数表
		for (int i = 0; i < height.length; i++) {
			countMap.put(height[i], 0);
			maximumMap.put(height[i], 1);
		}
		// 遍历height
		for (int i = 0; i < height.length; i++) {
			int h = height[i];
			// 对于每一个h，遍历计数表
			for (Map.Entry<Integer, Integer> cMap : countMap.entrySet()) {
				if (cMap.getKey() <= h) {
					// 高度小于等于h的块计数+1
					// 如果计数数量大于已记录的最大连续出现次数，更新最大次数计数表
					cMap.setValue(cMap.getValue() + 1);
					if (cMap.getValue() > maximumMap.get(cMap.getKey())) {
						maximumMap.put(cMap.getKey(), cMap.getValue());
					}
				} else {
					// 高度大于h的块计数清零
					cMap.setValue(0);
				}
			}
		}
		// 遍历最大次数计数表，获取最大面积的矩形
		int largest = 0;
		for (Map.Entry<Integer, Integer> mMap : maximumMap.entrySet()) {
			int h = mMap.getKey();
			int w = mMap.getValue();
			int area = h * w;
			if (area > largest) {
				largest = area;
			}
		}
		return largest;
	}
}
