package leetCode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0;
		int total = 0;
		int index = -1;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += sum;
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		if (total >= 0) {
			return index + 1;
		} else {
			return -1;
		}
	}
}
