
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
public class shortestPath {
	
	private static final class HeapEnrty implements Comparable<HeapEntry>{
		private final graphCells cell;
		private final double distance; // This is the priority key
		
		HeapEnrty(graphCells cell, double distance) {
			this.cell = cell;
			this.distance = distance;
		}

		graphCells getNode() {
			return cell;
		}
		@Override
		public int compareTo(HeapEntry o) {
			return Double.compare(distance, o.distance);
		}
		
	}
	public List<graphCells> search(graphCells source,
		 						graphCells goal,
		 						costFunction cost,
		 						computeHeuristic computeHeuristic){
		PriorityQueue<HeapEnrty> OPEN = new PriorityQueue<>();
		Set<graphCells> CLOSED = new HashSet<>();
		Map<graphCells, Double> DISTANCE = new HashMap<>();
		Map<graphCells, graphCells> PARENTS = new HashMap<>();
		
		OPEN.add(new HeapEntry(source, 0.0));
		DISTANCE.put(source, 0.0);
		PARENTS.put(source, null);
		
		while (!OPEN.isEmpty()) {
			graphCells currentCell = OPEN.remove().getNode();
			
			if(currentCell.equals(goal)) {
				return traceBackPath(currentCell, PARENTS);
			}
			if(CLOSED.contains(currentCell)) {
				continue;
			}
			for(graphCells childCell: currentCell.getSuccessor()) {
				if(CLOSED.contains(childCell)) {
					continue;
				}
				
				double tentativeDistance = DISTANCE.get(currentCell) + cost.get(currentCell, childCell);
				
				if(!DISTANCE.containsKey(currentCell) ||
						DISTANCE.get(childCell) > tentativeDistance) {
					DISTANCE.put(childCell, tentativeDistance);
					PARENTS.put(childCell, currentCell);
					OPEN.add(new HeapEnrty(childCell, 
							tentativeDistance + computeHeuristic.getEstimatedVal(childCell, goal)));
				}
			}
			
		}
		return new ArrayList<>();
	}
	private static List<graphCells>traceBackPath(graphCells target, Map<graphCells, graphCells> PARENTS){
		List<graphCells> path = new ArrayList<>();
		graphCells currentCell = target;
		while(currentCell != null) {
			path.add(currentCell);
			currentCell = PARENTS.get(currentCell);
		}
		return Collections.reverse(path);
	}

	
}
