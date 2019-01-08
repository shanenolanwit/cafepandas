package shane.nolan.wit.regression;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinearRegression {
	
	private final List<Integer> dataSetX;
	private final List<Integer> dataSetY;
	private final List<Integer> XY;
	private final List<Integer> xSquared;
	private final List<Integer> ySquared;
	private final int sumX;
	private final int sumY;
	private final int sumXY;
	private final int sumXsquared;
	private final int sumYsquared;
	private final int n;
	private final double a;
	private final double b;
	
	public SimpleLinearRegression(List<Integer> dataSetX, List<Integer> dataSetY){
		this.dataSetX = dataSetX;
		this.dataSetY = dataSetY;
		this.XY = new ArrayList<>();
		this.xSquared = new ArrayList<>();
		this.ySquared = new ArrayList<>();
		for(int i=0; i< dataSetX.size(); i++){
			int x = dataSetX.get(i);
			int y = dataSetY.get(i);
			XY.add(x*y);
			xSquared.add(x*x);
			ySquared.add(y*y);
		}
		this.n = dataSetX.size();
		this.sumX = dataSetX.stream().mapToInt(x -> Integer.valueOf(x)).sum();
		this.sumY = dataSetY.stream().mapToInt(x -> Integer.valueOf(x)).sum();
		this.sumXY = XY.stream().mapToInt(x -> Integer.valueOf(x)).sum();
		this.sumXsquared = xSquared.stream().mapToInt(x -> Integer.valueOf(x)).sum();
		this.sumYsquared = ySquared.stream().mapToInt(x -> Integer.valueOf(x)).sum();
		this.a = calculateA();
		this.b = calculateB();
	}	

	private double calculateA(){
		int calc1 = (getSumY()*getSumXsquared())-(getSumX()*getSumXY());
		int calc2 = (getN()*getSumXsquared())-(getSumX()*getSumX());
		return ((double)calc1/(double)calc2);
	}
	
	private double calculateB(){	
		int calc1 = (getN()*getSumXY())-(getSumX()*getSumY());		
		int calc2 = (getN()*getSumXsquared())-(getSumX()*getSumX());	
		return ((double)calc1/(double)calc2);
	}

	public List<Integer> getDataSetX() {
		return dataSetX;
	}

	public List<Integer> getDataSetY() {
		return dataSetY;
	}

	public List<Integer> getXY() {
		return XY;
	}

	public List<Integer> getxSquared() {
		return xSquared;
	}

	public List<Integer> getySquared() {
		return ySquared;
	}

	public int getN() {
		return n;
	}

	public int getSumX() {
		return sumX;
	}

	public int getSumY() {
		return sumY;
	}

	public int getSumXY() {
		return sumXY;
	}

	public int getSumXsquared() {
		return sumXsquared;
	}

	public int getSumYsquared() {
		return sumYsquared;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}	
	
	@Override
	public String toString(){
		String a = String.format("%.2f", getA());
		String b = String.format("%.2f", getB());
		return "y = " + a + " + " + b + "x";
	}

}
