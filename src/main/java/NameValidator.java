import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

    public static boolean validateName(String name) {
        return name != null && name.matches("[A-Za-złśćżźóąęŁŻ]+");

    }

    public static boolean validateLastName(String lastName) {
        return lastName != null && lastName.matches("[A-Za-złśćżźóąęŁŻĆ]+(-[A-Za-złśćżźóąęŁŻĆ])?");
    }


}
