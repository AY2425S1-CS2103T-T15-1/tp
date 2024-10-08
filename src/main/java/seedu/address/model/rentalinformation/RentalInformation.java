package seedu.address.model.rentalinformation;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Address;

/**
 * Represents a Rental Information in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class RentalInformation {
    private final Address address;
    private final RentalDate rentalStartDate;
    private final RentalDate rentalEndDate;
    private final RentDueDate rentDueDate;
    private final MonthlyRent monthlyRent;
    private final Deposit deposit;
    private final CustomerList customerList;

    /**
     * Constructs a {@code RentalInformation}.
     *
     * @param address A valid address.
     * @param rentalStartDate A valid rental start date.
     * @param rentalEndDate A valid rental end date.
     * @param rentDueDate A valid rent due date.
     * @param monthlyRent A valid monthly rent.
     * @param deposit A valid depost.
     * @param customerList A valid customer list.
     */
    public RentalInformation(String address, String rentalStartDate, String rentalEndDate, String rentDueDate,
                             String monthlyRent, String deposit, String customerList) {
        this.address = new Address(address);
        this.rentalStartDate = new RentalDate(rentalStartDate);
        this.rentalEndDate = new RentalDate(rentalEndDate);
        this.rentDueDate = new RentDueDate(rentDueDate);
        this.monthlyRent = new MonthlyRent(monthlyRent);
        this.deposit = new Deposit(deposit);
        this.customerList = new CustomerList(customerList);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RentalInformation)) {
            return false;
        }

        RentalInformation otherRentalInformation = (RentalInformation) other;
        return this.address.equals(otherRentalInformation.address)
                && this.rentalStartDate.equals(otherRentalInformation.rentalStartDate)
                && this.rentalEndDate.equals(otherRentalInformation.rentalEndDate)
                && this.rentDueDate.equals(otherRentalInformation.rentDueDate)
                && this.monthlyRent.equals(otherRentalInformation.monthlyRent)
                && this.deposit.equals(otherRentalInformation.deposit)
                && this.customerList.equals(otherRentalInformation.customerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, rentalStartDate, rentalEndDate, rentDueDate, monthlyRent, deposit, customerList);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("address", address)
                .add("rental start date", rentalStartDate)
                .add("rental end date", rentalEndDate)
                .add("rental due date", rentDueDate)
                .add("monthly rent", monthlyRent)
                .add("deposit", deposit)
                .add("customer list", customerList)
                .toString();
    }
}
