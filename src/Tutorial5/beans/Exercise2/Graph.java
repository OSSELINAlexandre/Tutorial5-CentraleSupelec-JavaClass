package Tutorial5.beans.Exercise2;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph<T, S, W> {

	private T id;
	private S name;
	private W caracteristics;
	private ArrayList<Edge<T, S>> listEdge;
	private ArrayList<Node<T, S>> listNode;
	private HashSet<S> visitedNodes = new HashSet<>();
	private ArrayList<T> pathway = new ArrayList<>();
	private int winning = 0;

	public Graph(T ID, S name, W caracteristic) {
		this.id = ID;
		this.name = name;
		this.caracteristics = caracteristic;
		this.listEdge = new ArrayList<Edge<T, S>>();
		this.listNode = new ArrayList<Node<T, S>>();
	}

	public Graph() {
		this.listEdge = new ArrayList<Edge<T, S>>();
		this.listNode = new ArrayList<Node<T, S>>();
	}

	public T getID() {
		return id;
	}

	public void setID(T ID) {
		this.id = ID;
	}

	public S getName() {
		return name;
	}

	public void setName(S name) {
		this.name = name;
	}

	public W getElsing() {
		return caracteristics;
	}

	public void setElsing(W elsing) {
		this.caracteristics = elsing;
	}

	public void addEdge(Edge<T, S> e) {
		listEdge.add(e);

	}

	public void addNode(Node<T, S> a) {
		listNode.add(a);
	}

	public ArrayList<Edge<T, S>> getEdges() {
		return listEdge;
	}

	public ArrayList<Node<T, S>> getNodes() {
		return listNode;
	}

	public Node<T, S> findNodeByID(T i) {
		for (int j = 0; j < listNode.size(); j++) {
			if (listNode.get(j).getId().equals(i))
				return listNode.get(j);
		}

		return null;
	}

	public Node<T, S> findNodeByInfo(S ok) {
		for (int j = 0; j < listNode.size(); j++) {
			if (listNode.get(j).getName().equals(ok))
				return listNode.get(j);
		}

		return null;
	}

	public ArrayList<T> findConnection(Node<T, S> Start, Node<T, S> Destionation) {

		Node<T, S> Current = Start;
		Node<T, S> CurrentNext = null;
		Node<T, S> CurrentNextNext = null;

		if ((!visitedNodes.contains(Current.getName())) && !(Start.getId().toString().equals("0"))) {

			visitedNodes.add(Current.getName());
			for (int j = 0; j < Current.getSuccessors().size(); j++) {
				CurrentNext = findNodeByID(Current.getSuccessors().get(j));
				for (int x = 0; x < CurrentNext.getSuccessors().size(); x++) {
					if (CurrentNext.getSuccessors().get(x) != Current.getId()
							&& !(CurrentNext.getSuccessors().get(x).equals("0"))) {
						CurrentNextNext = findNodeByID(CurrentNext.getSuccessors().get(x));
					}
				}

				if (Current.getName().toString().equals(Destionation.getName().toString())) {
					winning++;

					return null;
				}
				findConnection(CurrentNext, Destionation);

				if (winning > 0) {
					pathway.add(CurrentNext.getId());
					break;
				}

			}

		}
		if (winning > 0)
			return pathway;
		else
			return null;
	}

}
