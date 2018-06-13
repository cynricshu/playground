import com.example.tutorial.AddressBookProtos;
import com.example.tutorial.AddressBookProtos.Person;

public class AddressUtil {
    // This function fills in a Person message based on user input.
    public static Person generatePerson() {
        Person.Builder person = Person.newBuilder();

        person.setId(1);
        person.setName("hello world");
        person.setEmail("email");

        Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber("123456");
        phoneNumber.setType(Person.PhoneType.MOBILE);
        person.addPhones(phoneNumber);

        return person.build();
    }

    public static void print(AddressBookProtos.AddressBook addressBook) {
        for (Person person : addressBook.getPeopleList()) {
            System.out.println("Person ID: " + person.getId());
            System.out.println("  Name: " + person.getName());
            if (!person.getEmail().isEmpty()) {
                System.out.println("  E-mail address: " + person.getEmail());
            }

            for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
                switch (phoneNumber.getType()) {
                    case MOBILE:
                        System.out.print("  Mobile phone #: ");
                        break;
                    case HOME:
                        System.out.print("  Home phone #: ");
                        break;
                    case WORK:
                        System.out.print("  Work phone #: ");
                        break;
                    default:
                        System.out.println(" Unknown phone #: ");
                        break;
                }
                System.out.println(phoneNumber.getNumber());
            }
        }
    }
}