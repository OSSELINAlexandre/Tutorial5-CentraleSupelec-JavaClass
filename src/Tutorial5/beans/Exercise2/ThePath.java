package Tutorial5.beans.Exercise2;

import java.util.ArrayList;

public class ThePath {
	
	public ArrayList<String> names;
	public ArrayList<Integer> ids;
	
	
	public ThePath() {
		super();
		ids = new ArrayList<>();
		names = new ArrayList<>();
	}
	
	public ThePath(ArrayList<String> names, ArrayList<Integer> ids) {
		super();
		this.names = names;
		this.ids = ids;
	}
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public ArrayList<Integer> getIds() {
		return ids;
	}
	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}
	
	
}
