package seedu.address.model.rentalinformation;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Rental Information's monthly rent value in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMonthlyRent(String)}
 */
public class MonthlyRent {
    public static final String MESSAGE_CONSTRAINTS =
            "Monthly Rent should only contain numbers, and in 2 decimal places if needed";
    public static final String VALIDATION_REGEX = "^(0|(?!0)\\d+)(\\.\\d{2})?$";

    public final double monthlyRent;

    /**
     * Constructs a {@code MonthlyRent}.
     *
     * @param monthlyRent A valid monthly rent value.
     */
    public MonthlyRent(String monthlyRent) {
        requireNonNull(monthlyRent);
        checkArgument(isValidMonthlyRent(monthlyRent), MESSAGE_CONSTRAINTS);
        this.monthlyRent = Double.parseDouble(monthlyRent);
    }

    /**
     * Validates a monthly rent string against a predefined regex pattern.
     *
     * @param test The string to be validated as a monthly rent.
     * @return {@code true} if the string matches the validation regex;
     *         {@code false} otherwise.
     */
    public static boolean isValidMonthlyRent(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return Double.toString(monthlyRent);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MonthlyRent)) {
            return false;
        }

        MonthlyRent otherMonthlyRent = (MonthlyRent) other;
        return this.monthlyRent == otherMonthlyRent.monthlyRent;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(monthlyRent).hashCode();
    }
}
