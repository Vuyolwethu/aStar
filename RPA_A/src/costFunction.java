import java.util.HashMap;
import java.util.Map;

public class costFunction {
	private final Map<graphCells, Map<graphCells, Double>> map = new HashMap();
	
	public void set(graphCells tail, graphCells head, double cost) {
		map.putIfAbsent(tail, new HashMap<>());
		map.get(tail).put(head, cost);
	}
	
	public double get(graphCells tail, graphCells head) {
		return map.get(tail).get(head);
	}
}
