package shane.nolan.wit.kmeans;

import java.util.ArrayList;
import java.util.List;

import shane.nolan.wit.utils.MultiDimensionalPoint;
import shane.nolan.wit.utils.MultiDimensionalPointUtils;

/**
 * 
 * @author Shane Nolan
 *
 */
public class KmeansCluster {

	private final List<MultiDimensionalPoint> nodes;
	private final MultiDimensionalPoint centroid;

	/**
	 * Creates a new cluster using the provided nodes
	 * Centroid is automatically calculated using provided nodes
	 * @param nodes
	 */
	public KmeansCluster(List<MultiDimensionalPoint> nodes){
		super();		
		this.nodes = nodes;
		this.centroid = findCentroid();
	}
	
	/**
	 * Creates an empty cluster, provided centroid will be used when deciding what nodes to add
	 * @param centroid
	 */
	public KmeansCluster(MultiDimensionalPoint centroid) {
		super();
		this.centroid = centroid;
		this.nodes = new ArrayList<MultiDimensionalPoint>();
	}
	
	public MultiDimensionalPoint getCentroid() {
		return centroid;
	}
	
	public List<MultiDimensionalPoint> getNodes() {
		return nodes;
	}
	
	public MultiDimensionalPoint findCentroid(){
		return MultiDimensionalPointUtils.mean(getNodes());
	}

	@Override
	public String toString() {
		return "KmeansCluster [centroid=" + getCentroid() + ", size=" + getNodes().size() + ", nodes=" + getNodes() + "]";
	}
	
	
	
	
	
}
