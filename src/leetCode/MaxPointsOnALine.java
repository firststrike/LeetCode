package leetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		} else {
			Map<Point, Integer> tempPoints = new HashMap<Point, Integer>();
			for (int i = 0; i < points.length; i++) {
				if (tempPoints.get(points[i]) == null) {
					tempPoints.put(points[i], 1);
				} else {
					int c = tempPoints.get(points[i]);
					tempPoints.put(points[i], c + 1);
				}
			}
			Point[] newPoints = new Point[tempPoints.size()];
			int t = 0;
			for (Map.Entry<Point, Integer> point : tempPoints.entrySet()) {
				newPoints[t] = point.getKey();
				newPoints[t].count = point.getValue();
				t++;
			}
			if (newPoints.length < 3) {
				int r = 0;
				for (int i = 0; i < newPoints.length; i++) {
					r += newPoints[i].count;
				}
				return r;
			} else {
				int pointsCount = 2;
				for (int i = 0; i < newPoints.length; i++) {
					for (int j = i + 1; j < newPoints.length; j++) {
						newPoints[j].checkNum = i;
						Line line = new Line(newPoints[i], newPoints[j]);
						for (int k = j + 1; k < newPoints.length; k++) {
							if (newPoints[k].checkNum != i) {
								if (isSameLine(line, newPoints[k])) {
									newPoints[k].checkNum = i;
									line.pointsCount += newPoints[k].count;
								}
							}
						}
						if (line.pointsCount > pointsCount) {
							pointsCount = line.pointsCount;
						}
					}
				}
				return pointsCount;
			}
		}
	}

	/**
	 * 比较一个点是否在一条已知的直线上
	 * 
	 * @param line
	 * @param p
	 * @return
	 */
	private boolean isSameLine(Line line, Point p) {
		Point p0 = line.p0;
		int slopeX = p.x - p0.x;
		int slopeY = p.y - p0.y;
		if (line.slopeX * slopeY == line.slopeY * slopeX) {
			return true;
		} else {
			return false;
		}
	}
}

class Point {
	int x;
	int y;

	/**
	 * 个数
	 */
	int count;

	/**
	 * 上一个校验点
	 */
	int checkNum;

	Point() {
		x = 0;
		y = 0;
		checkNum = -1;
		count = 1;
	}

	Point(int a, int b) {
		x = a;
		y = b;
		checkNum = -1;
		count = 1;
	}

	/**
	 * 如果对象类型是Point 的话 则返回true 去比较hashCode值
	 */
	@Override
	public boolean equals(Object point) {
		if (point == null)
			return false;
		if (this == point)
			return true;
		if (point instanceof Point) {
			Point p = (Point) point;
			if (this.x == p.x && this.y == p.y)
				return true;
		}
		return false;
	}

	/**
	 * 重写hashcode 方法，返回的hashCode 不一样才认定为不同的对象
	 */
	@Override
	public int hashCode() {
		String coordinate = this.x + "," + this.y;
		return coordinate.hashCode();
	}
}

class Line {
	Point p0;
	Point p1;
	int slopeY;
	int slopeX;
	int pointsCount;

	public Line(Point p0, Point p1) {
		this.p0 = p0;
		this.p1 = p1;
		slopeY = p1.y - p0.y;
		slopeX = p1.x - p0.x;
		pointsCount = p0.count + p1.count;
	}
}
