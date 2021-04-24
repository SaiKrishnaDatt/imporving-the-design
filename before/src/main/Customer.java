package main;

import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 24/04/21, Sat
 **/
public class Customer {
  public String getName() {
    return name;
  }

  private final String name;

  public Customer(String name) {
    this.name = name;
  }

  private final List<Rental> rentals = new ArrayList<>();

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String statement() {
    Holder<Double> totalAmount = new Holder<>(0d);
    Holder<Integer> frequentRenterPoints = new Holder<>(0);
    StringBuilder result = new StringBuilder();
    result.append("Rental record for ").append(getName()).append("\n");
    rentals.forEach(rental -> {
      double thisAmount = 0;
      switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (rental.getDaysRented() > 2) {
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
          }
          break;
        case Movie.NEW_RELEASE:
          thisAmount += rental.getDaysRented() * 3;
          break;
        case Movie.CHILDREN:
          thisAmount += 1.5;
          if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
          break;
        default: //Do nothing.
      }
      //add frequent renter points
      frequentRenterPoints.value++;
      //add bonus points for a two day new release rental
      if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
        frequentRenterPoints.value++;
      //show figures for this rental
      result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
      totalAmount.value = totalAmount.value + thisAmount;
    });
//add footer lines
    result.append("Amount owed is ").append(totalAmount.value).append("\n");
    result.append("You earned ").append(frequentRenterPoints.value).append(" frequent renter points");
    return result.toString();
  }
}
