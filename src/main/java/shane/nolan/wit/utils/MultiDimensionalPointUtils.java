package shane.nolan.wit.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiDimensionalPointUtils {
	
	public static MultiDimensionalPoint average(List<MultiDimensionalPoint> nodes){
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
	
	public static boolean equals(MultiDimensionalPoint a, MultiDimensionalPoint b){
		boolean eq = a.getCoords().size() == b.getCoords().size();
		int size = a.getCoords().size();
		int i = 0;
		while(i < size && eq){
			double aiRound = new BigDecimal(a.getCoords().get(i)).setScale(10, RoundingMode.HALF_UP).doubleValue();
			double biRound = new BigDecimal(b.getCoords().get(i)).setScale(10, RoundingMode.HALF_UP).doubleValue();
			eq = (aiRound == biRound);
			i++;
		}
		return eq;
	}
	
	public static boolean equals(List<MultiDimensionalPoint>a, List<MultiDimensionalPoint>b){
		boolean eq = a.size() == b.size();
		int size = a.size();
		int i = 0;
		while(i < size && eq){
			eq = (a.get(i).equals(b.get(i)));
			if(!eq){
				System.out.println(a.get(i) + " does not match " + b.get(i));
			}
			i++;
		}
		return eq;
	}
}
