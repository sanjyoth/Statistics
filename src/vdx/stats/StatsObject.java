package vdx.stats;

/**
 * 
 * @author sanjyoth
 * StatsObject represents actual value and creation time in seconds
 *
 */
public class StatsObject {
	int value;
	int createMin;
	
	
	public StatsObject(int value, int createMin) {
		this.value = value;
		this.createMin = createMin;
		
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCreateMin() {
		return createMin;
	}
	public void setCreateMin(int createMin) {
		this.createMin = createMin;
	}
	
	
}
