import contact_table.UserNotFoundException;
import contact_table.Users;
import contact_table.UsersUtil;
import java.util.List;
import java.util.Scanner;

public class Main {

    public  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Введите номер контакта: ");
            String number = scanner.nextLine();
            List<Users> result = UsersUtil.findUserByFullName(number);
            for (Users contact:result){
                System.out.println(contact.getFirstName() + " " + contact.getLastName());
            }
        } catch (UserNotFoundException e) {
            System.out.println("Контакт не найден");
        }
    }
}
