package StructAndAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Loop {
	
	ArrayList<Node> nodelist = new ArrayList<Node>();//邻接表
	Set<Node> a = new HashSet<Node>();

	public void findcycle() {//删去无用边和顶点
		Node now = null;
		if (nodelist.size() == 0)
			System.out.println("No Loop!");
		for (Node tem : nodelist) {
			if (tem.outdegree == 0) {
				now = tem;
				break;
			}
		}
		if (now == null) {
			
			findloop();
		} else {
			nodelist.remove(now);
			for (Node tem : now.next)
				tem.outdegree--;
			findcycle();
		}
	}

	public void findloop() {
		while (nodelist.size() != 0) {
			Node tem = nodelist.get(0);
			a.add(tem);
			LinkedList<Node> history = new LinkedList<Node>();
			history.push(tem);
			dfsfind(tem, history);
			nodelist.removeAll(a);
			//System.out.println(nodelist);
			a.clear();
		}
	}
	public void dfsfind(Node tem, LinkedList<Node> history) {
		for (Node t : tem.next) {
			if (!history.contains(t)) {
				a.add(t);
				history.push(t);
				dfsfind(t, history);
			} else {
				String s = t.value + "";
				//System.out.println(s);
				for (int i = history.indexOf(tem); i <= history.indexOf(t); i++)
					s = history.get(i).value + s;
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
        Loop temp = new Loop();
		Node nod1 =new Node('1');
		Node nod2 =new Node('2');
		Node nod3 =new Node('3');
		Node nod4 =new Node('4');
		Node nod5=new Node('5');
		Node nod6=new Node('6');
		nod1.add(nod6);
		nod6.add(nod1);
		nod4.add(nod5);
		nod5.add(nod2);
		nod5.add(nod3);
		nod3.add(nod4);
		nod2.add(nod4);
		temp.nodelist.add(nod1);
		temp.nodelist.add(nod2);
		temp.nodelist.add(nod3);
		temp.nodelist.add(nod4);
		temp.nodelist.add(nod5);
		temp.nodelist.add(nod6);
		temp.findcycle();
	}
}


