package Tutorial5.beans.Exercise2;

public class Edge<T, S> {

    private S neighborName;
    private T id;
    private T name;

    public Edge(S neighborname, T ID, T name) {
        this.neighborName = neighborname;
        this.id = ID;
        this.name = name;
    }

    public Edge() {
    }

    public S getneighborName() {
        return neighborName;
    }

    public void setneighborName(S n) {
        neighborName = n;
    }


    public void setID(T ID) {
        this.id = ID;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
