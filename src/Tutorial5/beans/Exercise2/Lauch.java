package Tutorial5.beans.Exercise2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lauch {

	private ArrayList<Integer> routeID = new ArrayList<>();
	private ArrayList<String> routeName = new ArrayList<>();
	private Map<String, Integer> fullrouteAvailable = new HashMap<>();
	
	public Map<String, Integer>  loadingDB(){
		
		try {
			MetroMapParser mmp = new MetroMapParser(
					"C:\\Users\\FamilleOSSELIN\\eclipse-workspace\\MetroMapGui\\src\\Tutorial5\\beans\\Exercise2\\bostonmetro.txt");
			mmp.generateGraphFromFile();
			
			for(int i = 1 ; i <= 124 ; i++) {
				fullrouteAvailable.put(mmp.metroGraph.findNodeByID(i).getName(), i );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fullrouteAvailable;
	}

	public ThePath treatingRequest(int start, int end) {
		ThePath tpih = null;

		try {
			MetroMapParser mmp = new MetroMapParser(
					"C:\\Users\\FamilleOSSELIN\\eclipse-workspace\\MetroMapGui\\src\\Tutorial5\\beans\\Exercise2\\bostonmetro.txt");
			mmp.generateGraphFromFile();
			routeID = mmp.metroGraph.findConnection(mmp.metroGraph.findNodeByID(start), mmp.metroGraph.findNodeByID(end));
			routeID.add(mmp.metroGraph.findNodeByID(start).getId());
			System.out.println(routeID);
			Collections.reverse(routeID);
			System.out.println("connection " + mmp.metroGraph.findNodeByID(start).getName() + " and "
					+ mmp.metroGraph.findNodeByID(end).getName() + " :" + routeID);
			
			for (Integer e : routeID) {

				routeName.add(mmp.metroGraph.findNodeByID(e).getName());
				
			}
			
			for (String e : routeName) {

				System.out.println(e);
				
			}
			
			for (Integer e : routeID) {

				System.out.println(e);
				
			}
			
			tpih = new ThePath(routeName ,routeID);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tpih;
	}
}
