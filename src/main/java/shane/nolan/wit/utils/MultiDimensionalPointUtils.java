package shane.nolan.wit.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiDimensionalPointUtils {
	
	/**
	 * Given a list of nodes with n dimensions
	 * Find the mean of each dimension (ie mean x, mean y, mean z etc)
	 * @param nodes
	 * @return
	 */
	public static MultiDimensionalPoint mean(List<MultiDimensionalPoint> nodes){
		int dimensions = nodes.get(0).getCoords().size();	
		List<Double> centroidCoords = IntStream.range(0, dimensions)
				.mapToDouble((i) -> {
					return nodes
							.stream()
							.mapToDouble(node -> node.getCoords().get(i))
							.average()
							.getAsDouble();
				})
				.boxed() //convert from stream of primitives to stream of object wrappers (double to Double)
				.collect(Collectors.toList());
		
		return new MultiDimensionalPoint(centroidCoords);
	}
	
	/**
	 * Given a list of nodes with n dimensions
	 * Find the average of each dimension (ie average x, average y, average z etc)
	 * @param nodes
	 * @return
	 */
	public static MultiDimensionalPoint median(List<MultiDimensionalPoint> nodes){
		int dimensions = nodes.get(0).getCoords().size();	
		List<Double> centroidCoords = IntStream.range(0, dimensions)
				.mapToDouble((i) -> {
					return MultiDimensionalPointUtils.dimensionMedian(
							nodes
							.stream()
							.mapToDouble(node -> node.getCoords().get(i))
							.boxed()
							.collect(Collectors.toList())
						);
				})
				.boxed() //convert from stream of primitives to stream of object wrappers (double to Double)
				.collect(Collectors.toList());
		
		return new MultiDimensionalPoint(centroidCoords);
	}
	
	public static Double dimensionMedian(List<Double> vals){
		Collections.sort(vals);
		int valsize = vals.size()/2;
		Double median = vals.get(valsize);
		if(valsize%2 == 0){
			median = (vals.get(valsize)+vals.get(valsize-1))/2;
		}
		return median;
	}
	
	/**
	 * Checks if two multi-dimensional points are equal or close to equal
	 * Closeness defined by scale and rounding mode
	 * @param a - first multi-dimensional point
	 * @param b - second multi-dimensional point
	 * @param scale - decimal places
	 * @param roundingMode - Rounding mode to apply when scaling
	 * @return
	 */
	public static boolean equals(
			MultiDimensionalPoint a, 
			MultiDimensionalPoint b, 
			int scale, 
			RoundingMode roundingMode){
		boolean eq = a.getCoords().size() == b.getCoords().size();
		int size = a.getCoords().size();
		int i = 0;
		while(i < size && eq){
			double aiRound = new BigDecimal(a.getCoords().get(i)).setScale(scale, roundingMode).doubleValue();
			double biRound = new BigDecimal(b.getCoords().get(i)).setScale(scale, roundingMode).doubleValue();
			eq = (aiRound == biRound);
			i++;
		}
		return eq;
	}
	
	/**
	 * Checks if two lists of multi-dimensional points are equal or close to equal
	 * Closeness defined by scale and rounding mode
	 * @param a - first list multi-dimensional point
	 * @param b - second list multi-dimensional point
	 * @param scale - decimal places
	 * @param roundingMode - Rounding mode to apply when scaling
	 * @return
	 */
	public static boolean equals(
			List<MultiDimensionalPoint> a, 
			List<MultiDimensionalPoint> b,
			int scale,
			RoundingMode roundingMode){
		boolean eq = a.size() == b.size();
		int size = a.size();
		int i = 0;
		while(i < size && eq){
			eq = MultiDimensionalPointUtils.equals(a.get(i), b.get(i), scale, roundingMode);
			if(!eq){
				System.out.println(a.get(i) + " does not match " + b.get(i));
			}
			i++;
		}
		return eq;
	}
}
