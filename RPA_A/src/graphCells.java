import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class graphCells {
	private final int myId;
	private final Set<graphCells> children = new HashSet<>();
	
	public graphCells(int myId) {
		this.myId = myId;
	}
	
	public void addNewCell(graphCells child) {
		children.add(child);
	}
	public Set<graphCells> getSuccessor(){
		return Collections.unmodifiableSet(children);
	}
	@Override
	public boolean equals(Object o) {
		if(o == null || !getClass().equals(o.getClass())) {
			return false;
		}
		return myId == ((graphCells) o).myId;
	}
	
	@Override
	public int hashCode() {
		return myId;
	}
	public String toString() {
		return "[graphCell ID is "+ myId +"]";
	}
}
