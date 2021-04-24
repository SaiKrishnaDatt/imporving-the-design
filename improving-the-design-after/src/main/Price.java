package main;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
abstract class Price {
  abstract int getPriceCode();

  abstract double getCharges(int daysRented);

  public int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}
