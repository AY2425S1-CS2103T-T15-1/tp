package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.client.EmailContainsKeywordsPredicate;
import seedu.address.model.client.NameContainsKeywordsPredicate;
import seedu.address.model.client.PhoneContainsKeywordsPredicate;
import seedu.address.model.client.RentalInformationContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose attributes contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice";

    private final NameContainsKeywordsPredicate namePredicate;
    private final PhoneContainsKeywordsPredicate phonePredicate;
    private final EmailContainsKeywordsPredicate emailPredicate;

    private final RentalInformationContainsKeywordsPredicate rentalInfoPredicate;

    /**
     * Constructs a {@code FindCommand} with the given name, phone and email predicates.
     * The command will find all clients whose name, phone and email matches the predicates.
     */
    public FindCommand(NameContainsKeywordsPredicate namePredicate, PhoneContainsKeywordsPredicate phonePredicate,
                       EmailContainsKeywordsPredicate emailPredicate,
                       RentalInformationContainsKeywordsPredicate rentalInfoPredicate) {
        this.namePredicate = namePredicate;
        this.phonePredicate = phonePredicate;
        this.emailPredicate = emailPredicate;
        this.rentalInfoPredicate = rentalInfoPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(namePredicate.or(phonePredicate).or(emailPredicate).or(rentalInfoPredicate));
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    // TODO: update this equals method
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FindCommand)) {
            return false;
        }

        FindCommand otherFindCommand = (FindCommand) other;
        return namePredicate.equals(otherFindCommand.namePredicate)
                && phonePredicate.equals(otherFindCommand.phonePredicate)
                && emailPredicate.equals(otherFindCommand.emailPredicate)
                && rentalInfoPredicate.equals(otherFindCommand.rentalInfoPredicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("namePredicate", namePredicate)
                .add("phonePredicate", phonePredicate)
                .add("emailPredicate", emailPredicate)
                .add("rentalInfoPredicate", rentalInfoPredicate)
                .toString();
    }
}
