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
      frequentRenterPoints.value += rental.getFrequentRenterPoints();
      //show figures for this rental
      result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge()).append("\n");
      totalAmount.value += rental.getCharge();
    });
//add footer lines
    result.append("Amount owed is ").append(getTotalCharge()).append("\n");
    result.append("You earned ").append(getFrequentRenterPoints()).append(" frequent renter points");
    return result.toString();
  }

  private double getTotalCharge() {
    return rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  private int getFrequentRenterPoints() {
    return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

}
