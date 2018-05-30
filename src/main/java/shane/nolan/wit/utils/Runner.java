package shane.nolan.wit.utils;

import java.util.Arrays;
import java.util.List;

import shane.nolan.wit.kmeans.KmeansModel;

public class Runner {

	public static void main(String[] args){

		List<MultiDimensionalPoint> centroids = Arrays.asList(
				new MultiDimensionalPoint(Arrays.asList(10.0,10.0)),	
				new MultiDimensionalPoint(Arrays.asList(7.0,7.0)),	
				new MultiDimensionalPoint(Arrays.asList(1.0,1.0))	
		);
		List<MultiDimensionalPoint> nodes = Arrays.asList(
				new MultiDimensionalPoint(Arrays.asList(1.0,1.0)),	
				new MultiDimensionalPoint(Arrays.asList(-4.0,0.0)),	
				new MultiDimensionalPoint(Arrays.asList(4.0,0.0)),	
				new MultiDimensionalPoint(Arrays.asList(5.0,6.0)),	
				new MultiDimensionalPoint(Arrays.asList(6.0,6.0)),	
				new MultiDimensionalPoint(Arrays.asList(7.0,7.0)),	
				new MultiDimensionalPoint(Arrays.asList(10.0,10.0))	
		);
		
		
		new KmeansModel(nodes, centroids, 3, 10, new EuclideanCalculator());
		
		
		
	}
	
	
}
