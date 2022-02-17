import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            //Product product = session.get(Product.class, 2);
            //System.out.println(product);
            Category category = session.get(Category.class, 1);
            System.out.println(category);
        }finally {
            factory.close();
            session.close();
        }
    }
}
