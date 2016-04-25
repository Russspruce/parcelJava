public class Parcels {

  private static double mLength;
  private static double mWidth;
  private static double mHeight;
  private static double mVolume;
  private static double mDistance;
  private double mWeight;
  private double mCost;

  public Parcels(double length, double width, double height, double weight, double distance) {
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
    mDistance = distance;
  }

  public static double getVolume() {
    mVolume = mLength * mWidth * mHeight;
    return mVolume;
  }

  public static double getDistanceCost() {
    if (mDistance < 100) {
      return 3.5;
    } else if (mDistance < 1000) {
      return 5;
    } else {
      return 12;
    }
  }

  public double costToShip() {
    mCost = ( (Parcels.getVolume()) + (mWeight * .5) + (Parcels.getDistanceCost()) );
    return mCost;
  }
}
