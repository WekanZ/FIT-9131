package ass;

public class Trail {
	// instance variables - replace the example below with your own
	private NatureFeature[] features = new NatureFeature[4];

	/**
	 * Constructor for objects of class Trail
	 */
	public Trail() {
		// initialise instance variables
		NatureFeature[] features = new NatureFeature[4];
	}

	public void trailNatureFeatures(int trailLength) // the detail of different
	{
		Dice dice = new Dice();
		int a = dice.generateDiceNumber(trailLength-2, 1);
		int b = dice.generateDiceNumber(trailLength-2, 1);
		int c = dice.generateDiceNumber(trailLength-2, 1);
		int d = dice.generateDiceNumber(trailLength-2, 1);
		while(a==b||a==c||a==d||b==c||b==d||c==d) {
			a = dice.generateDiceNumber(trailLength-2, 1);
			b = dice.generateDiceNumber(trailLength-2, 1);
			c = dice.generateDiceNumber(trailLength-2, 1);
			d = dice.generateDiceNumber(trailLength-2, 1);
		}
		this.features[0] = new NatureFeature(a, "Creek", -2);
		this.features[1] = new NatureFeature(b, "Bridge", 4);
		this.features[2] = new NatureFeature(c, "Fallen tree", -3);
		this.features[3] = new NatureFeature(d, "Landslide", -5);
	}

//	public void displayFeatureInformation() { // display the feature information
//		int i = 0;
//		while (i <= 3) {
//			System.out.println("The feature type is: " + this.features[i].getFeatureType()
//					+ ",the feature position is : " + this.features[i].getFeaturePosition()
//					+ ", the feature penalty is : " + this.features[i].getSpacePenalty());
//			// for( int i = 0; i<=3; i++){
//			// System.out.println("The feature type is: " +
//			// this.features[i].getFeatureType() +
//			// ",the feature position is : " + this.features[i].getFeaturePosition() +
//			// ", the feature penalty is : " + this.features[i].getSpacePenalty());
//
//		}
//	}

	public NatureFeature[] getFeatures()// accessor
	{
		return features;
	}

	public void setFeatures(NatureFeature[] features)// mutator
	{
		this.features = features;
	}
}
