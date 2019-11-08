package FinnRute;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PathFinder {

	public static List<Node> hentLokasjonar(String file) throws FileNotFoundException, IOException {

		String filnavn = "src/FinnRute/routes.csv";
		if (file.length() == 0) {

		} else {
			filnavn = file;
		}

		return Hjelpeklasse.noderFraCSV(filnavn);
	}

	public static String fromTo(String from, String to, String file) throws FileNotFoundException, IOException {

		String filnavn = "src/FinnRute/routes.csv";
		if (file.length() == 0) {

		} else {
			filnavn = file;
		}
		List<Node> noder = Hjelpeklasse.noderFraCSV(filnavn);

		noder = Hjelpeklasse.leggTilKanter(noder, filnavn);

		Graph graph = new Graph();

		for (Node node : noder) {
			graph.addNode(node);
		}

		Node startnode = Hjelpeklasse.finnNode(noder, from);

		graph = Dijkstra.finnKortesteVeg(graph, startnode);

		String outputString = "";
		for (Node node : graph.getNodes()) {

			if (node.getName().equals(to)) {

				for (Node path : node.getKortesteSti()) {
					outputString += path.getName() + " -> ";
				}
				outputString += node.getName() + " : " + node.getDistance() + "minutes";
			}

		}

		return outputString;
	}
}
