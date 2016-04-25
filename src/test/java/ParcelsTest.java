import org.junit.*;
import static org.junit.Assert.*;

public class ParcelsTest {

  @Test
  public void hasVolume_volumeTotal_volume() {
    Parcels testParcels = new Parcels(2, 3, 4, 1, 1);
    Double expected = 24.0;
    assertEquals(expected, (Double) testParcels.getVolume());
  }

  @Test
  public void getDistanceCost_distanceRangeCost_cost() {
    Parcels testParcels = new Parcels(1, 1, 1, 1, 2000);
    Double expected = 12.0;
    assertEquals(expected, (Double) testParcels.getDistanceCost());
  }

  @Test
  public void costToShip_totalCostToShip_cost() {
    Parcels testParcels = new Parcels(2, 3, 4, 8, 200);
    Double expected = 33.0;
    assertEquals(expected, (Double) testParcels.costToShip());
  }

}
