package Tutorial5.beans.Exercise2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;




/*
*
* Information for the reader :
*
* The class "MetroMapParser" & "BadFile Exception" were already given in the tutorial.
*
*Therefore, the generic Types for Graph could be find easily. It was basically reverse engineering.
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */

/**
 *
 * a class for parsing formatted textual files that contains the description of
 * the metro network of a city
 *
 */
public class MetroMapParser {

    /**
     * the metromap-file containing the textual description of the metro network to be parsed
     */
    private BufferedReader fileInput;

    /**
     * the graph where the result of parsing is going to be stored
     */
    public Tutorial5.beans.Exercise2.Graph<Integer,String,String> metroGraph = new Tutorial5.beans.Exercise2.Graph<Integer,String,String>();


    public MetroMapParser(){

    }


    /**
     * Builds a MetroMapParser  linked to a metromap-file with a given filename
     * @param filename: the file containing the textual description of the metro network to be parsed
     * @throws IOException
     */
    public MetroMapParser(String filename) throws IOException {
        //a buffered reader reads line by line, returning null when file is done
        fileInput = new BufferedReader(new FileReader(filename));
    }


    /**
     * parses the fileinput and store the outcome into the metroGraph
     * @throws IOException if problem reading fileinput
     * @throws BadFileException if hte format of fileinput is not correct
     */
    public  void  generateGraphFromFile() throws IOException, Tutorial5.beans.Exercise2.BadFileException {
        String line = fileInput.readLine();
        StringTokenizer st;
        String stationID;
        String stationName;
        String lineName;
        String outboundID, inboundID;




        while(line != null) {
            //in this loop, the program  collec the information necessary to
            //construct the metro graph, and  construct the graph as well.
            //
            //StringTokenizer is a java.util Class that can break a string into tokens
            // based on a specified delimiter.  The default delimiter is " \t\n\r\f" which
            // corresponds to the space character, the tab character, the newline character,
            // the carriage-return character and the form-feed character.
            st = new StringTokenizer(line);

            //We want to handle empty lines effectively, we just ignore them!
            if(!st.hasMoreTokens()) {
                line = fileInput.readLine();
                continue;
            }

            //from the grammar, we know that the Station ID is the first token on the line
            stationID = st.nextToken();

            if(!st.hasMoreTokens()) {
                throw new Tutorial5.beans.Exercise2.BadFileException("no station name");
            }

            //from the grammar, we know that the Station Name is the second token on the line.
            stationName = st.nextToken();

            //MetroStation aStation = new MetroStation(Integer.parseInt(stationID),stationName);
            Tutorial5.beans.Exercise2.Node<Integer,String> aMetroStation = new Tutorial5.beans.Exercise2.Node<Integer, String>(Integer.parseInt(stationID), stationName);

            if(!st.hasMoreTokens()) {
                throw new Tutorial5.beans.Exercise2.BadFileException("station is on no lines");
            }

            while(st.hasMoreTokens()) {
                lineName = st.nextToken();
                if(!st.hasMoreTokens()) {
                    throw new Tutorial5.beans.Exercise2.BadFileException("poorly formatted line info");
                }
                outboundID = st.nextToken();
                if(!st.hasMoreTokens()) {
                    throw new Tutorial5.beans.Exercise2.BadFileException("poorly formatted adjacent stations");
                }
                inboundID = st.nextToken();
                //Edge<String> anEdge = new Edge<String>(lineName, Integer.parseInt(outboundID), Integer.parseInt(inboundID));
                this.metroGraph.addEdge(new Tutorial5.beans.Exercise2.Edge<Integer,String>(lineName, Integer.parseInt(outboundID), Integer.parseInt(inboundID)));
                this.metroGraph.addEdge(new Tutorial5.beans.Exercise2.Edge<Integer,String>(lineName, Integer.parseInt(inboundID), Integer.parseInt(outboundID)));

                Integer num_outboundID = Integer.parseInt(outboundID);
                Integer num_inboundID = Integer.parseInt(inboundID);

                if(num_outboundID != 0){
                    aMetroStation.addSuccessor(num_outboundID);
                }

                if(num_inboundID != 0){
                    aMetroStation.addSuccessor(num_inboundID);
                }


            }

            this.metroGraph.addNode(aMetroStation);

            line = fileInput.readLine();
        }
    }



    /**
     * his a simple main method to test locally whether the parser works as expected
     * it requires passing the name of the metromapfile as the first parameter of the main
     * @param args the first argument must be the name of the file containing the metro map
     */
/*    public static void main(String[] args) {
*//*        if(args.length != 1) {
            System.out.println("Pass the fileinput name as parameter to the main method");
            System.exit(0);
        }*//*
        String filename = ".\\bostonmetro.txt";

        try {
            MetroMapParser mmp = new MetroMapParser(filename);
            mmp.generateGraphFromFile();
            System.out.println("scanned stations: " + mmp.toString());
            System.out.println("bostonMetrograph NODES: " + mmp.metroGraph.getNodes());
            System.out.println("bostonMetrograph EDGES: " + mmp.metroGraph.getEdges());

*//*            for(osselin.alexandre.Exercise2.Node<Integer,String> n:mmp.metroGraph.getNodes()){
                if(n.getId().equals(1)){
                    System.out.println("node " + n.getNodeInfo() + " successors: " + n.getSuccessors());
                }
                if(n.getId().equals(119)){
                    System.out.println("node " + n.getNodeInfo() + " successors: " + n.getSuccessors());
                }
            }*//*
            ArrayList<Integer> route;
            route = mmp.metroGraph.findConnection(mmp.metroGraph.findNodeByID(1), 	mmp.metroGraph.findNodeByID(14));
            Collections.reverse(route);
            System.out.println("connection " +  mmp.metroGraph.findNodeByID(1).getName() + " and " + mmp.metroGraph.findNodeByID(14).getName()  + " :" + route );
            System.out.println("found node by name OakGroove:" + mmp.metroGraph.findNodeByInfo("OakGrove"));
            System.out.println("found node by ID 1:" + mmp.metroGraph.findNodeByID(1));


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }*/

}
