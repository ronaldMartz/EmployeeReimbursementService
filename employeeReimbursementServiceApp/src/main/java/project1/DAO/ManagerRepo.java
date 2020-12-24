package project1.DAO;

import io.javalin.http.Context;
import org.hibernate.Query;
import org.hibernate.Session;
import project1.models.EmployeeTable;
import project1.util.ConnectionDao;

import java.util.List;

public class ManagerRepo extends ConnectionDao {

    public static List<EmployeeTable> ParseEmployees(){
        config();
        Session session = sessionFactory.openSession();

        String hql = "from EmployeeTable";
        Query query = session.createQuery(hql);

        List requests = query.list();

        return requests;
    }
}
