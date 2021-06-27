package vdx.stats;

/**
 * 
 * @author sanjyoth
 *
 */
public interface Statistics {
	
	void event(int value);
	float mean();
	float mean(int lastNMin);
	float variance();
	int minimum();
	int maximum();
}
