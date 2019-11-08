package FinnRute;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hjelpeklasse {

	public static Node finnNode(List<Node> noder, String navn) {
		for (Node node : noder) {
			if (node.getName().equals(navn)) {
				return node;
			}
		}
		return null;
	}

	public static List<Node> noderFraCSV(String string) throws FileNotFoundException, IOException {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(string))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				records.add(Arrays.asList(values));
			}
		}

		List<String> noder = new ArrayList<String>();

		for (List<String> linje : records) {
			if (!noder.contains(linje.get(0))) {
				noder.add(linje.get(0));
			}

			if (!noder.contains(linje.get(1))) {
				noder.add(linje.get(1));
			}

		}
		List<Node> nodes = new ArrayList<Node>();

		noder.forEach(x -> nodes.add(new Node(x)));

		return nodes;
	}

	public static List<List<String>> kanterFraCSV(String string) throws FileNotFoundException, IOException {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(string))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				records.add(Arrays.asList(values));
			}
		}

		return records;
	}

	public static List<Node> leggTilKanter(List<Node> noder, String filnavn) throws FileNotFoundException, IOException {

		List<List<String>> records = kanterFraCSV(filnavn);
		for (List<String> element : records ) {
			finnNode(noder, element.get(0)).leggtilDestinasjon(finnNode(noder, element.get(1)), Integer.valueOf(element.get(2)));
		}
		return noder;

	}

}
