package seedu.address.model.rentalinformation;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Rental Information's deposit value in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeposit(String)}
 */
public class Deposit {
    public static final String MESSAGE_CONSTRAINTS =
            "Deposit should only contain numbers, and in 2 decimal places if needed";
    public static final String VALIDATION_REGEX = "^(0|(?!0)\\d+)(\\.\\d{2})?$";

    public final double deposit;

    /**
     * Constructs a {@code Deposit}.
     *
     * @param deposit A valid deposit value.
     */
    public Deposit(String deposit) {
        requireNonNull(deposit);
        checkArgument(isValidDeposit(deposit), MESSAGE_CONSTRAINTS);
        this.deposit = Double.parseDouble(deposit);
    }

    /**
     * Validates a deposit string against a predefined regex pattern.
     *
     * @param test The string to be validated as a deposit.
     * @return {@code true} if the string matches the validation regex;
     *         {@code false} otherwise.
     */
    public static boolean isValidDeposit(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return Double.toString(deposit);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Deposit)) {
            return false;
        }

        Deposit otherDeposit = (Deposit) other;
        return this.deposit == otherDeposit.deposit;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(deposit).hashCode();
    }
}
