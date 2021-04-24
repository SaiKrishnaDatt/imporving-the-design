package main;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
public class NewReleasePrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  double getCharges(int daysRented) {
    return daysRented * 3;
  }

  public int getFrequentRenterPoints(int daysRented) {
    return (daysRented > 1) ? 2 : 1;
  }
}
