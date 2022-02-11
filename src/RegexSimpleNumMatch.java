import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexSimpleNumMatch {

    public static void main(String[] args) {

        String input = "abc00123xyz456_0";
        String regexStr = "[0-9]+";            // Regex looks only for number combinations

        Pattern pattern = Pattern.compile(regexStr); //compile the pattern, so it can be used to match input

        Matcher matcher = pattern.matcher(input); // it needs a "Matcher" to compare pattern against input

        while (matcher.find()) {  // "while" there is a match in the input (next match)
            System.out.println("find() encountered substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        }

        // Try Matcher.matches(), which tries to match the ENTIRE input (^...$)
        if (matcher.matches()) {
            System.out.println("matches() encountered substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        } else {
            System.out.println("matches() encountered nothing");
        }

        // Try Matcher.lookingAt(), which tries to match from the START of the input (^...)
        if (matcher.lookingAt()) {
            System.out.println("lookingAt() encountered substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
        } else {
            System.out.println("lookingAt() encountered nothing");
        }

        // Try Matcher.replaceFirst(), which replaces the first match
        String replacementStr = "**";
        String outputStr = matcher.replaceFirst(replacementStr); // first match only
        System.out.println("First match replaced : " + outputStr);

        // Try Matcher.replaceAll(), which replaces all matches
        replacementStr = "++";
        outputStr = matcher.replaceAll(replacementStr); // all matches
        System.out.println("All matches replaced: " + outputStr);
    }
}
