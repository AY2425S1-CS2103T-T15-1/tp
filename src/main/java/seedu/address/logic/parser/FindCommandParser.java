package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_KEYWORD;

import java.util.List;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.EmailContainsKeywordsPredicate;
import seedu.address.model.client.NameContainsKeywordsPredicate;
import seedu.address.model.client.PhoneContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(trimmedArgs, PREFIX_KEYWORD);
        if (argMultimap.getValue(PREFIX_KEYWORD).isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
        List<String> keywords = argMultimap.getAllValues(PREFIX_KEYWORD);

        return new FindCommand(new NameContainsKeywordsPredicate(keywords),
                new PhoneContainsKeywordsPredicate(keywords),
                new EmailContainsKeywordsPredicate(keywords));
    }

}
