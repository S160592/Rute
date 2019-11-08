package FinnRute;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;



public class Dijkstra {

	public static Graph finnKortesteVeg(Graph graph, Node source) {
	    source.setDistance(0);
	 
	    Set<Node> besoktNode = new HashSet<>();
	    Set<Node> ikkjeBesoktNode = new HashSet<>();
	 
	    ikkjeBesoktNode.add(source);
	 
	    while (ikkjeBesoktNode.size() != 0) {
	        Node aktuellNode = getLavesteAvstandNode(ikkjeBesoktNode);
	        ikkjeBesoktNode.remove(aktuellNode);
	        for (Entry <Node,Integer> naboPar: 
	          aktuellNode.hentNaboNodar().entrySet()) {
	            Node naboNode = naboPar.getKey();
	            Integer kantVekt = naboPar.getValue();
	            if (!besoktNode.contains(naboNode)) {
	                kalkulerMinimumAvstand(naboNode, kantVekt, aktuellNode);
	                ikkjeBesoktNode.add(naboNode);
	            }
	        }
	        besoktNode.add(aktuellNode);
	    }
	    return graph;
	}
	private static Node getLavesteAvstandNode(Set < Node > ikkjeBesokteNoder) {
	    Node lavesteAvstandNode = null;
	    int lavesteAvstand = Integer.MAX_VALUE;
	    for (Node node: ikkjeBesokteNoder) {
	        int nodeAvstand = node.getDistance();
	        if (nodeAvstand < lavesteAvstand) {
	            lavesteAvstand = nodeAvstand;
	            lavesteAvstandNode = node;
	        }
	    }
	    return lavesteAvstandNode;
	}
	
	private static void kalkulerMinimumAvstand(Node node,
			  Integer kantVekt, Node kildeNode) {
			    Integer kildeAvstand = kildeNode.getDistance();
			    if (kildeAvstand + kantVekt < node.getDistance()) {
			        node.setDistance(kildeAvstand + kantVekt);
			        LinkedList<Node> kortesteSti = new LinkedList<>(kildeNode.getKortesteSti());
			        kortesteSti.add(kildeNode);
			        node.setKortesteSti(kortesteSti);
			    }
			}
}
