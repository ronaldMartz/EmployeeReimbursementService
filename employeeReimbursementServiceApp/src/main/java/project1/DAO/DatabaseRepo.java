package project1.DAO;

import io.javalin.http.Context;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project1.models.ReimbursementTable;
import project1.util.ConnectionDao;

import java.util.List;

public class DatabaseRepo extends ConnectionDao {

    public static List<ReimbursementTable> ParseTable(Integer id){
        config();
        Session session = sessionFactory.openSession();

        String hql = "from ReimbursementTable where requesting_id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        List requests = query.list();

        session.close();

        return requests;
    }

    public static void submitRequest(Context ctx, Integer empId){
        config();

        Session session = sessionFactory.openSession();

        String sql = "insert into reimbursement(request_date,requesting_id,request_amount,reason,resolution) " +
                "values (current_date,?,?,?,?);";
        Query query = session.createSQLQuery(sql);
        query.setInteger(0,empId);
        query.setDouble(1,Double.parseDouble(ctx.formParam("amount")));
        query.setString(2,ctx.formParam("reason"));
        query.setString(3,"Pending");
        Transaction tx = session.beginTransaction();
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    public static List<ReimbursementTable> ParseFullTable(){
        config();
        Session session = sessionFactory.openSession();

        String hql = "from ReimbursementTable";
        Query query = session.createQuery(hql);

        List requests = query.list();

        session.close();

        return requests;
    }
}
