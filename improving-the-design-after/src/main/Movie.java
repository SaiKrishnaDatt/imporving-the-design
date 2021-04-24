package main;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private final String title;
  private Price price;


  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public String getTitle() {
    return title;
  }

  public int getPriceCode() {
    return price.getPriceCode();
  }

  public void setPriceCode(int priceCode) {

    switch (priceCode) {
      case REGULAR:
        price = new RegularPrice();
        break;
      case CHILDREN:
        price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect price code");
    }
  }

  public double getCharge(int daysRented) {
    return price.getCharges(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return price.getFrequentRenterPoints(daysRented);
  }
}
