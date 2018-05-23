package shane.nolan.wit.utils;

public class EuclideanCalculator implements DimensionalCalculator {
	
	

	@Override
	public double distance(MultiDimensionalPoint a, MultiDimensionalPoint b) {
		double total = 0.0;
		for(int i=0; i< a.getCoords().size(); i++){
			total += Math.pow(a.getCoords().get(i)-b.getCoords().get(i), 2);
		}
		return Math.sqrt(total);
	}
	
	
	
	



	
}
