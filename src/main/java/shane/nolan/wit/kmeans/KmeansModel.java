package shane.nolan.wit.kmeans;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import shane.nolan.wit.utils.DimensionalCalculator;
import shane.nolan.wit.utils.MultiDimensionalPoint;
import shane.nolan.wit.utils.MultiDimensionalPointUtils;

public class KmeansModel {
	
	private List<KmeansCluster> clusters;
	private List<MultiDimensionalPoint> centroids;
	private final List<MultiDimensionalPoint> nodes;
	private final int k;
	private final int maxIterations;
	private final DimensionalCalculator calculator;
	
	//Scale and Rounding Mode used for tweaking equality method
	private final int scale;
	private final RoundingMode roundingMode;
	
	/**
	 * 
	 * @param nodes
	 * @param k - number of clusters
	 * @param maxIterations - max number of iterations
	 */
	public KmeansModel(
			List<MultiDimensionalPoint> nodes, 
			int k, 
			int maxIterations, 
			DimensionalCalculator calculator,
			int scale,
			RoundingMode roundingMode){
		this.k = k;		
		this.maxIterations = maxIterations;	
		this.scale = scale;
		this.roundingMode = roundingMode;
		this.nodes = nodes;
		this.calculator = calculator;
		this.centroids = getRandomCentroids();		
		this.clusters = assignNodesToCentroids();
		execute();		
	}
	
	public KmeansModel(
			List<MultiDimensionalPoint> nodes, 
			List<MultiDimensionalPoint> centroids, 
			int k, 
			int maxIterations, 
			DimensionalCalculator calculator 
			){
		this.k = k;		
		this.calculator = calculator;
		this.maxIterations = maxIterations;	
		this.scale = 10;
		this.roundingMode = RoundingMode.HALF_UP;
		this.nodes = nodes;
		this.centroids = centroids;		
		this.clusters = assignNodesToCentroids();
		execute();		
	}
	
	private void execute(){
		System.out.println("Starting centroids : " + getCentroids());
		int i = 1;
		List<MultiDimensionalPoint> oldCentroids = getCentroids();
		boolean centroidsMatch = false;
		while(i<=getMaxIterations() && !centroidsMatch){
			List<MultiDimensionalPoint> newCentroids = getClusters().stream().map(cluster -> cluster.findCentroid()).collect(Collectors.toList());
			setCentroids(newCentroids);
			setClusters(assignNodesToCentroids());			
			
			if(MultiDimensionalPointUtils.equals(oldCentroids,getCentroids(),getScale(),getRoundingMode())){
				centroidsMatch = true;
				System.out.println("Centroids match at iteration " + i);				
			} else{
				System.out.println("Centroids not matching at iteration " + i);
				oldCentroids = getCentroids();
			}
			for(KmeansCluster cluster : getClusters()){
				System.out.println(cluster);
			}
			i++;
		}
	}
	
	
	
	private List<KmeansCluster> assignNodesToCentroids(){
		List<KmeansCluster> clusters = getCentroids().stream()
				.map(centroid -> new KmeansCluster(centroid))
				.collect(Collectors.toList());
		
		for(MultiDimensionalPoint node : getNodes()){
			MultiDimensionalPoint nearestCentroid = nearestCentroid(node);			
			KmeansCluster cluster = clusters.stream()
					.filter(c -> c.getCentroid().equals(nearestCentroid))
					.findFirst()
					.get();
			cluster.getNodes().add(node);
		}
		
		return clusters;
	}
	
	private MultiDimensionalPoint nearestCentroid(MultiDimensionalPoint node){
		Map<Double,MultiDimensionalPoint> distanceMap = getCentroids().stream()
				.collect(
					Collectors.toMap(
						centroid -> getCalculator().distance(node,centroid), 	//key
						centroid -> centroid,					  				//value
						(k1,k2) -> { return k1; } 								//duplicate key resolver
					));
		
		Optional<Double> minValue = distanceMap.keySet().stream().min((a,b) -> Double.compare(a, b));
		MultiDimensionalPoint nearestCentroid = getCentroids().get(0);
		if(!minValue.isPresent()){
			System.out.println("Strange no min");
		}else {
			nearestCentroid = distanceMap.get(minValue.get());
		}
		return nearestCentroid;
	}

	public List<KmeansCluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<KmeansCluster> clusters) {
		this.clusters = clusters;
	}

	public List<MultiDimensionalPoint> getCentroids() {
		return centroids;
	}

	public void setCentroids(List<MultiDimensionalPoint> centroids) {
		this.centroids = centroids;
	}	

	public List<MultiDimensionalPoint> getNodes() {
		return nodes;
	}

	/**
	 * Number of clusters k
	 * @return
	 */
	public int getK() {
		return k;
	}
	
	public DimensionalCalculator getCalculator() {
		return calculator;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public int getScale() {
		return scale;
	}

	public RoundingMode getRoundingMode() {
		return roundingMode;
	}

	private List<MultiDimensionalPoint> getRandomCentroids(){
		List<MultiDimensionalPoint> centroids = new ArrayList<MultiDimensionalPoint>(getK());
		Collections.shuffle(getNodes());
		for(int i=0; i<getK(); i++){
			centroids.add(getNodes().get(i));
		}
		System.out.println("centroids being randomly generated...");
		return centroids;
	}
	
	
	
	
		

}
