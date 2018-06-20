import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
public class myAStar {

	public static void main(String[] args) {
		long random_state = System.nanoTime();
		Random random = new Random(random_state);
		System.out.println("random_state" + random_state);
	}
	
	private static List<graphCells> getRandomGraph(int cells, int arcs, Random random){
		List<graphCells> graph = new ArrayList<>(cells);
		for (int id=0; id < cells;id++) {
			graph.add(new graphCells(id));
		}
		
		while(arcs --> 0) {
			graphCells tail = choose(graph, random);
			graphCells head = choose(graph, random);
			tail.addNewCell(head);
			--arcs;
		}
		return graph;
	}
	private static xyCoordinates getCoordinates(List<graphCells> graph) {
		xyCoordinates coordinates = new xyCoordinates();
		
		for(graphCells cell: graph) {
			coordinates.put(1000.0, 1000.0, random);
		}
		return coordinates;
	}
	
	private static costFunction getCostFunction(List<graphCells> graph, graphCells coordinates) {
		
	}
	private static Point2D.Double randomPoint(double width, double height, Random random){
		return new Point2D.Double(width + random.nextDouble(),  height + random.nextDouble());
	}
	private static <T> T choose(List<T> list, Random random) {
		return list.get(random.nextInt(list.size()));
	}

}
