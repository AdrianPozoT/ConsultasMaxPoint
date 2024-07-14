package demo_jdbc.models;

public class ConstructorMaxPoint {
	
	private String constructorName;
	private float points;
	
	public ConstructorMaxPoint(String constructorName, float points) {
		super();
		this.constructorName = constructorName;
		this.points = points;
	}

	public String getConstructorName() {
		return constructorName;
	}

	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}
	
	

	
	
	
}
