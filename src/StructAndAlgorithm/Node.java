package StructAndAlgorithm;

import java.util.ArrayList;


public class Node {
	char value;
	int outdegree = 0;
	ArrayList<Node> next = new ArrayList<Node>();

	
	public Node(char value) {
		this.value = value;
	}

	public void add(Node t) {
		next.add(t);
		outdegree++;
	}
}
