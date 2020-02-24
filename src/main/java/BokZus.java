import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BokZus {
    public static void main(String[] args) {
        System.out.println("Witaj drogi kliencie ZUS: ");

        String name;
        String lastName;
        String pesel;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoje imię: ");
        name = scanner.nextLine();
        while (!NameValidator.validateName(name)){
            System.out.println("Podałeś niepoprawne imię, wpisz ponownie:");
            name = scanner.nextLine();
        }

        System.out.println("Podaj swoje nazwisko: ");
        lastName = scanner.nextLine();
        while (!NameValidator.validateLastName(lastName)){
            System.out.println("Podałeś niepoprawny format nazwiska, wpisz ponownie:");
            lastName = scanner.nextLine();

        }

        System.out.println("Podaj swój nr pesel: ");
        pesel = scanner.nextLine();
        while (!PeselUtils.validate(pesel)){
            System.out.println("Podałeś niepoprawny PESEL, wpisz ponownie:");
            pesel = scanner.nextLine();


        }

        System.out.println("Imię: " + name + "\n" + "Nazwisko: " + lastName + "\n" + "numer pesel: " + pesel);

        System.out.println("Płęć: " + PeselUtils.readSex(pesel));

        System.out.println("Data urodzenia: " + PeselUtils.readDateOfBirth(pesel));

//        System.out.printf("Imię: %s, nazwisko: %s, PESEL: %s", name,lastName,pesel);

        Client client = new Client(name,lastName,pesel);

        System.out.println(client);
        LocalDate now = LocalDate.now();
        int wiek = (int) ChronoUnit.YEARS.between(PeselUtils.readDateOfBirth(pesel),now);
        System.out.println("Twoj wiek: " + wiek + " lat/a");
        if (wiek < 65){
            LocalDate wiekEmerytalny = PeselUtils.readDateOfBirth(pesel).plusYears(65);
            long dniDoEmerytury = ChronoUnit.DAYS.between(now,wiekEmerytalny);
            System.out.println("Pozostało Ci do emerytury: " + dniDoEmerytury + " dni! :(");
        } else {
            System.out.println("Masz prawo do emyrytury. Odbierz kasę i baw się dobrze!! :)");
        }



    }
}
