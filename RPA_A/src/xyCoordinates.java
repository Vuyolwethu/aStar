import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class xyCoordinates {

	private final Map<graphCells, Point2D.Double> map = new HashMap();
	
	public void put(graphCells cell, Point2D.Double point) {
		map.put(cell, point);
	}
	
	public Point2D.Double get(graphCells cell){
		return map.get(cell);
	}
}
