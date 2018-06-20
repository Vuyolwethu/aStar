
public class euclideanHeuristic implements computeHeuristic {

	private final xyCoordinates coordinates;
	
	public euclideanHeuristic(xyCoordinates coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public double getEstimatedVal(graphCells cell0, graphCells cell1) {
		return coordinates.get(cell0).distance(coordinates.get(cell1));
	}
}
