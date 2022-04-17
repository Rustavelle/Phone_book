package contact_table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsersUtil {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");

    public static List<Users> findUserByFullName(String number) throws UserNotFoundException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Users> usersTypedQuery = manager.createQuery("select u from Users u where " +
                "u.phoneNumber = ?1", Users.class);
        usersTypedQuery.setParameter(1, number);
        List<Users> usersList = usersTypedQuery.getResultList();
        if (usersList.isEmpty()) {
            throw new UserNotFoundException();
        }
        return usersList;
    }
}

