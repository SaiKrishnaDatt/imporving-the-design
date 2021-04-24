package main;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
public class Rental {
  private final Movie movie;
  private final int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public double getCharge() {
    return movie.getCharge(daysRented);
  }

  public int getFrequentRenterPoints() {
    return movie.getFrequentRenterPoints(daysRented);
  }
}
