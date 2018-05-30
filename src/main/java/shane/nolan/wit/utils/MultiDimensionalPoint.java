package shane.nolan.wit.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Shane Nolan
 *
 */
public class MultiDimensionalPoint {
	
	//List of dimensional values eg [4,8,2] would be 4 on the x axis, 8 on the y axis, 2 on the z axis etc
	private final List<Double> coords;
	
	public MultiDimensionalPoint(Double... coords){
		this.coords = Arrays.asList(coords);
	}

	public MultiDimensionalPoint(List<Double> coords) {
		super();
		this.coords = coords;
	}
	
	public List<Double> getCoords() {
		return coords;
	}

	@Override
	public String toString() {
		return "MultiDimensionalPoint [coords=" + coords + "]";
	}
	
	

}
