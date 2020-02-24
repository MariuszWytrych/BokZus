import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class PeselUtils {

    public static boolean validate(String pesel) {
        return pesel != null && pesel.matches("\\d{11}");
    }

    public static char readSex(String pesel) {
        char male = 'M';
        char female = 'F';
        char wrongPesel = '0';
        String tenNumberOfPesel = pesel.substring(9, 10);
        int sexNumber = Integer.parseInt(tenNumberOfPesel);
        if (sexNumber % 2 == 0) {
            return female;
        } else if (sexNumber % 2 == 1) {
            return male;
        } else {
            return wrongPesel;
        }


    }

    public static LocalDate readDateOfBirth(String pesel){
        String peselDate = pesel.substring(0,6);
        String year = peselDate.substring(0,2);
        String month = peselDate.substring(2,4);
        String day = peselDate.substring(4,6);
        int intYear = Integer.parseInt(year);
        int intMonth = Integer.parseInt(month);
        int intDay = Integer.parseInt(day);


        if (intMonth > 12){
            intYear = intYear + 2000;
            intMonth = intMonth - 20;
            return LocalDate.of(intYear,intMonth,intDay);
        }
        else if(intMonth <= 12){
            intYear = intYear + 1900;
            return LocalDate.of(intYear,intMonth,intDay);
        }else {
            return LocalDate.MIN;
        }


    }
}

