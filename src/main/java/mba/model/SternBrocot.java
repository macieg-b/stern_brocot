package mba.model;

import java.util.*;

public class SternBrocot {
	private Map<Integer, List<Node>> nodeList = new HashMap<>();
	private int maxLevel;

	public void build(int a, int b, int c, int d, int level, int maxLevel) {
		if (level == maxLevel + 1) return;
		int x = a + c, y = b + d;
		List<Node> currentList = nodeList.get(level);
		if (currentList == null) currentList = new ArrayList<>();
		currentList.add(Node.builder()
				.x(x)
				.y(y)
				.level(level)
				.build());
		nodeList.put(level, currentList);
		build(a, b, x, y, level + 1, maxLevel);
		build(x, y, c, d, level + 1, maxLevel);
	}

	public String find(int x, int y, int a, int b, int c, int d, int level, int maxLevel) {
		int m = a + c, n = b + d;
		if (x == m && y == n)
			return "";
		if (level == maxLevel) return "";
		if (x * n < y * m)
			return 'L' + find(x, y, a, b, m, n, level + 1, maxLevel);
		else
			return 'R' + find(x, y, m, n, c, d, level + 1, maxLevel);
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer key : nodeList.keySet()) {
			List<Node> nodes = nodeList.get(key);
			stringBuilder.append(String.join("", Collections.nCopies(maxLevel - key, "\t")));
			for (Node node : nodes) {
				stringBuilder.append(node.toString());
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
