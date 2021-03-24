package Tutorial5.beans.Exercise2;


import java.util.ArrayList;

public class Node<T, S> {

    private T id;
    private S name;
    private ArrayList<T> sucessor;

    public Node(T ID, S name) {
        this.id = ID;
        this.name = name;
        sucessor = new ArrayList<T>();
    }

    public Node() {
        sucessor = new ArrayList<T>();
    }

    public T getId() {
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

    public void addSuccessor(T i){
        sucessor.add(i);
    }

    public S getNodeInfo(){
        return name;
    }

    public ArrayList<T> getSuccessors(){
       return sucessor;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
