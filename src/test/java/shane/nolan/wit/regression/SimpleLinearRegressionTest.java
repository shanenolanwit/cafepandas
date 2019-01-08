package shane.nolan.wit.regression;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleLinearRegressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//https://www.statisticshowto.datasciencecentral.com/probability-and-statistics/regression-analysis/find-a-linear-regression-equation/
		List<Integer> dataSetX = Arrays.asList(43,21,25,42,57,59);
		List<Integer> dataSetY = Arrays.asList(99,65,79,75,87,81);
		SimpleLinearRegression slr = new SimpleLinearRegression(dataSetX, dataSetY);	
		assertEquals("65.14",String.format("%.2f", slr.getA()));
		assertEquals("0.39",String.format("%.2f", slr.getB()));
		assertEquals("Variables should be rounded to two decimals","y = 65.14 + 0.39x", slr.toString());
	}

}
