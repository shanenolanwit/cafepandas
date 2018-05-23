package shane.nolan.wit.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MultiDimensionalPoint {
	
	private final List<Double> coords;

	public MultiDimensionalPoint(List<Double> coords) {
		super();
		this.coords = coords;
	}

	public List<Double> getCoords() {
		return coords;
	}
	
	public boolean equals(MultiDimensionalPoint other){
		boolean eq = this.getCoords().size() == other.getCoords().size();
		int size = this.getCoords().size();
		int i = 0;
		while(i < size && eq){
			double a = new BigDecimal(this.getCoords().get(i)).setScale(10, RoundingMode.HALF_UP).doubleValue();
			double b = new BigDecimal(other.getCoords().get(i)).setScale(10, RoundingMode.HALF_UP).doubleValue();
			eq = (a == b);
			i++;
		}
		return eq;
	}	

	@Override
	public String toString() {
		return "MultiDimensionalPoint [coords=" + coords + "]";
	}
	
	

}
