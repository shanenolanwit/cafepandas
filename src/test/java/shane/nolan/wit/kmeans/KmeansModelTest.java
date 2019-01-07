package shane.nolan.wit.kmeans;
import org.junit.Test;

import shane.nolan.wit.utils.EuclideanCalculator;
import shane.nolan.wit.utils.MultiDimensionalPoint;
import shane.nolan.wit.utils.MultiDimensionalPointUtils;

import static org.junit.Assert.*;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/*
 *
 * @author shane, @date 22/05/18 15:37
 */
public class KmeansModelTest {
    @Test 
    public void modelTests() {
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
		assertEquals("K should be 3", 3, model.getK());
		assertEquals("Cluster size should be 3", 3, model.getClusters().size());
        assertEquals("Centroids size should be 3", 3, model.getCentroids().size());
        assertTrue("All clusters should have at least 1 node",
        		model.getClusters().stream().allMatch(c -> c.getNodes().size() > 0));
        MultiDimensionalPoint p1 = new MultiDimensionalPoint(Arrays.asList(10.0,10.0));
        MultiDimensionalPoint p2 = new MultiDimensionalPoint(Arrays.asList(6.0, 6.333333333333333));
        MultiDimensionalPoint p3 = new MultiDimensionalPoint(Arrays.asList(0.3333333333333333, 0.3333333333333333));
        MultiDimensionalPoint p4 = new MultiDimensionalPoint(Arrays.asList(7.0,0.333));
        assertTrue(model.getCentroids().stream().anyMatch(c -> MultiDimensionalPointUtils.equals(c, p1, 10, RoundingMode.HALF_UP)));
        assertTrue(model.getCentroids().stream().anyMatch(c -> MultiDimensionalPointUtils.equals(c, p2, 10, RoundingMode.HALF_UP)));
        assertTrue(model.getCentroids().stream().anyMatch(c -> MultiDimensionalPointUtils.equals(c, p3, 10, RoundingMode.HALF_UP)));
        assertFalse(model.getCentroids().stream().anyMatch(c -> MultiDimensionalPointUtils.equals(c, p4, 10, RoundingMode.HALF_UP)));
    }
}
