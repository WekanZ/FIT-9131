package ass;

import java.util.Random;

public class NatureFeature {
	// instance variables - replace the example below with your own
	private int featurePosition;
	private String featureType;
	private int spacePenalty;

	/**
	 * Constructor for objects of class NatureFeature
	 */
	public NatureFeature() {
		featurePosition = 0;
		featureType = "";
		spacePenalty = 0;
	}

	public NatureFeature(int trailLength, String FeatureType, int SpacePenalty) {
		Random randomPosition;
		randomPosition = new Random();
		this.featurePosition = randomPosition.nextInt(trailLength);
		this.featureType = FeatureType;
		this.spacePenalty = SpacePenalty;
	}

	public int getFeaturePosition() {
		return featurePosition;
	}

	public String getFeatureType() {
		return featureType;
	}

	public int getSpacePenalty() {
		return spacePenalty;
	}

	public void setFeaturePosition(int FeaturePosition) {
		this.featurePosition = FeaturePosition;
	}

	public void setFeatureType(String FeatureType) {
		this.featureType = FeatureType;
	}

	public void setSpacePenalty(int SpacePenalty) {
		this.spacePenalty = SpacePenalty;
	}

}
