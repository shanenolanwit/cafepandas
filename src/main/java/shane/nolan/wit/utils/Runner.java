package shane.nolan.wit.utils;

import java.util.Arrays;
import java.util.List;

import shane.nolan.wit.kmeans.KmeansModel;

public class Runner {

	public static void main(String[] args){
		EuclideanCalculator calc = new EuclideanCalculator();
		MultiDimensionalPoint a = new MultiDimensionalPoint(Arrays.asList(2.0,2.0,2.0));
		MultiDimensionalPoint b = new MultiDimensionalPoint(Arrays.asList(4.0,0.0,0.0));
		double dist = calc.distance(a, b);
		System.out.println(dist);
		
		MultiDimensionalPoint c = new MultiDimensionalPoint(Arrays.asList(2.0,8.0,3.0));
		MultiDimensionalPoint d = new MultiDimensionalPoint(Arrays.asList(4.0,4.0,0.0));
//		MultiDimensionalPoint e = calc.findCentroid(Arrays.asList(c,d));
//		System.out.println(e.getCoords());
		
		 c = new MultiDimensionalPoint(Arrays.asList(4.0,4.0));
		 d = new MultiDimensionalPoint(Arrays.asList(10.0,0.0));
		 b = new MultiDimensionalPoint(Arrays.asList(5.0,7.0));
//		 e = calc.findCentroid(Arrays.asList(b,c,d));
//		System.out.println(e.getCoords());
		
		List<MultiDimensionalPoint> centroids = Arrays.asList(
				//random : [MultiDimensionalPoint ords=[1.0, 1.0]]]
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
		
		
		KmeansModel model = new KmeansModel(nodes, centroids, 3, 10, new EuclideanCalculator());
		
		
		
	}
	
	
}
