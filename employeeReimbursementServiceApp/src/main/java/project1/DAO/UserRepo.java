package project1.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import project1.models.EmployeeTable;
import project1.util.ConnectionDao;

public class UserRepo extends ConnectionDao {


    public static EmployeeTable Authentication(String user, String hash){
        config();
        Session session = sessionFactory.openSession();
        String hql = "from EmployeeTable where email = :id";
        Query query = session.createQuery(hql);
        query.setString("id", user);

        EmployeeTable result = (EmployeeTable) query.list().get(0);

        if(result.getHash().equals(hash)) {
            session.close();
            return result;
        }
        else{
            return null;
        }
    }
}
