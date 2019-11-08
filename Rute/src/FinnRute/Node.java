package FinnRute;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
	   private String name;
	     
	    private List<Node> kortesteSti = new LinkedList<>();
	     
	    private Integer distance = Integer.MAX_VALUE;
	     
	    Map<Node, Integer> naboNodar = new HashMap<>();
	 
	    public void leggtilDestinasjon(Node destinasjon, int avstand) {
	        naboNodar.put(destinasjon, avstand);
	        destinasjon.leggtilEnkeltDestinasjon(this, avstand);
	    }
	  
	    public Node(String name) {
	        this.name = name;
	    }
	    
	    public void leggtilEnkeltDestinasjon(Node destination, int distance) {
	    	naboNodar.put(destination, distance );
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Node> getKortesteSti() {
			return kortesteSti;
		}

		public void setKortesteSti(List<Node> kortesteSti) {
			this.kortesteSti = kortesteSti;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}

		public Map<Node, Integer> hentNaboNodar() {
			return naboNodar;
		}

		public void setNaboNodar(Map<Node, Integer> naboNodar) {
			this.naboNodar = naboNodar;
		}
	     
	  

}
