package vdx.stats;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Author: Sanjyoth We are going to use design for interface philosophy
 *
 */
public class StatisticsImpl implements Statistics {

	// statisList is intentionally made synchronized to make it ThreadSafe
	static List<StatsObject> statsList = Collections.synchronizedList(new ArrayList<StatsObject>());

	/*
	 * now object is going to be used to calculate time differences in seconds.
	 * ASSUMPTION: In order to speed up the results using SECONDS in place of
	 * MINUTES
	 */
	static Calendar now = Calendar.getInstance();

	// START_TIME will hold the start of the program
	static int START_TIME = now.get(Calendar.SECOND);

	// MIN_VALUE & MAX_VALUE are the design tradeOffs made to avoid processing time
	// used during runtime to find min/max value within the stream till now
	static int MIN_VALUE = Integer.MAX_VALUE;
	static int MAX_VALUE = Integer.MIN_VALUE;

	/*
	 * event(): method used to populate the incoming integers from multiple threads
	 * into statsList which is a synchronized thread. TRADE-OFF: In order to avoid
	 * memory consumption and avoid processing time to calculate min and max values,
	 * saving them in separate variables so we can get them in constant time.
	 */
	public void event(int value) {
		StatsObject so = new StatsObject(value, now.get(Calendar.SECOND));
		System.out.println("Stats Object:" + so.getValue() + " at " + so.getCreateMin());
		synchronized (statsList) {
			statsList.add(so);
			if (value < MIN_VALUE)
				MIN_VALUE = value;
			if (value > MAX_VALUE)
				MAX_VALUE = value;
		}

	}

	/*
	 * mean(): method used to calculate mean of all integers present within
	 * synchronized statsList
	 */
	public float mean() {
		float sum = 0;
		synchronized (statsList) {
			for (StatsObject obj : statsList) {
				sum += obj.getValue();
			}
			return (sum / statsList.size());
		}
	}

	/*
	 * mean(): method used to calculate mean for last N minutes of all integers
	 * present within synchronized statsList NOTE: Here instead of Minutes we are
	 * calculating at seconds to get results faster
	 */
	public float mean(int lastNMin) {
		float sum = 0;
		synchronized (statsList) {
			for (StatsObject obj : statsList) {
				sum += obj.getValue();
				if (obj.getCreateMin() - START_TIME > lastNMin) {
					break;
				}
			}
			return (sum / statsList.size());

		}

	}

	/*
	 * variance(): method used to calculate variance of all integers present within
	 * synchronized statsList
	 */
	public float variance() {
		float mean = mean();
		float sum = 0;
		synchronized (statsList) {
			for (StatsObject obj : statsList) {
				sum += Math.pow((obj.getValue() - mean), 2);
			}
			return (sum / statsList.size());
		}

	}

	/*
	 * minimum(): returns the minimum values seen in statsList till now.
	 */
	public int minimum() {
		synchronized (statsList) {
			return MIN_VALUE;
		}

	}

	/*
	 * maximum(): returns the maximum values seen in statsList till now
	 */
	public int maximum() {
		synchronized (statsList) {
			return MAX_VALUE;
		}

	}

}
