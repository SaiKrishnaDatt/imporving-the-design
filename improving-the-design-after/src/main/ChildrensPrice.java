package main;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
public class ChildrensPrice extends Price {
  @Override
  int getPriceCode() {
    return Movie.CHILDREN;
  }

  double getCharges(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }
}
