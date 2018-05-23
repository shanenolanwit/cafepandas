package shane.nolan.wit.kmeans;

import java.util.ArrayList;
import java.util.List;

import shane.nolan.wit.utils.MultiDimensionalPoint;
import shane.nolan.wit.utils.MultiDimensionalPointUtils;

public class KmeansCluster {

	private final MultiDimensionalPoint centroid;
	private final List<MultiDimensionalPoint> nodes;
	
	public KmeansCluster(MultiDimensionalPoint centroid, List<MultiDimensionalPoint> nodes) {
		super();
		this.centroid = centroid;
		this.nodes = nodes;
	}
	
	public KmeansCluster(List<MultiDimensionalPoint> nodes){
		super();		
		this.nodes = nodes;
		this.centroid = findCentroid();
	}
	
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
		return MultiDimensionalPointUtils.average(getNodes());
	}

	@Override
	public String toString() {
		return "KmeansCluster [centroid=" + getCentroid() + ", size=" + getNodes().size() + ", nodes=" + getNodes() + "]";
	}
	
	
	
	
	
}
