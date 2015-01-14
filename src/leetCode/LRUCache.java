package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	CacheNode cacheFirst;
	CacheNode cacheLast;
	Map<Integer, CacheNode> cacheMap;
	int length;
	int capacity;

	public LRUCache(int capacity) {
		cacheFirst = null;
		cacheLast = null;
		cacheMap = new HashMap<Integer, CacheNode>(capacity * 3);
		this.capacity = capacity;
		this.length = 0;
	}

	public int get(int key) {
		CacheNode node = cacheMap.get(key);
		if (node != null) {
			remove(node);
			node.setLastNode(null);
			add(node);
			//System.out.println(node.getValue());
			return node.getValue();
		} else {
			//System.out.println(-1);
			return -1;
		}
	}

	public void set(int key, int value) {
		CacheNode node = new CacheNode(key, value);
		if (cacheMap.get(key) != null) {
			remove(cacheMap.get(key));
		}
		add(node);
		cacheMap.put(key, node);
		if (this.length > this.capacity) {
			cacheMap.remove(this.cacheLast.getKey());
			remove();
		}
	}

	private void add(CacheNode node) {
		if (this.cacheFirst == null && this.cacheLast == null) {
			this.cacheFirst = node;
			this.cacheLast = node;
		} else {
			this.cacheFirst.setLastNode(node);
			node.setNextNode(this.cacheFirst);
			this.cacheFirst = node;
		}
		this.length++;
	}

	private void remove() {
		if (this.capacity > 1) {
			this.cacheLast.getLastNode().setNextNode(null);
			this.cacheLast = this.cacheLast.getLastNode();
		} else {
			this.cacheFirst = null;
			this.cacheLast = null;
		}
		this.length--;
	}

	private void remove(CacheNode node) {
		node.remove();
		if (node == this.cacheFirst) {
			this.cacheFirst = this.cacheFirst.getNextNode();
		}
		if (node == this.cacheLast) {
			this.cacheLast = this.cacheLast.getLastNode();
		}
		this.length--;
	}
}

class CacheNode {
	private CacheNode lastNode;
	private CacheNode nextNode;
	private int key;
	private int value;

	public CacheNode(int key, int value) {
		this.lastNode = null;
		this.nextNode = null;
		this.key = key;
		this.value = value;
	}

	public void remove() {
		if (this.lastNode != null) {
			this.lastNode.setNextNode(this.nextNode);
		}
		if (this.nextNode != null) {
			this.nextNode.setLastNode(this.lastNode);
		}
	}

	public CacheNode getLastNode() {
		return lastNode;
	}

	public void setLastNode(CacheNode lastNode) {
		this.lastNode = lastNode;
	}

	public CacheNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(CacheNode nextNode) {
		this.nextNode = nextNode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}