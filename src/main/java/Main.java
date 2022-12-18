import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Car.class)/*!!!!!!! register class*/
                        .addAnnotatedClass(Engine.class)
                        .addAnnotatedClass(Technical_passport.class)
                        .addAnnotatedClass(Wheel.class)
                        .addAnnotatedClass(Wheel_Type.class)
                        .addAnnotatedClass(Passenger.class)
                        .addAnnotatedClass(Driver.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        ///work space with databases
        Engine e=new Engine(3.1);
        session.save(e);

        session.save(new Car("BMW",e,new Technical_passport(false),
                Arrays.asList(new Passenger("vasya"),new Passenger("vitya"))));
        session.save(new Car("Opel",new Engine(1.7),new Technical_passport(true)));

        Car audi=new Car("Audi",new Engine(4.1),new Technical_passport(true));
        session.save(audi);

        Wheel firstWheelForAudi=new Wheel(Wheel_Type.WINTER,audi);
        Wheel secondWheelForAudi=new Wheel(Wheel_Type.WINTER,audi);
        session.save(firstWheelForAudi);
        session.save(secondWheelForAudi);

        session.save(new Car("Bmmw",new Engine(4.5),Arrays.asList(new Driver("Vasya"),new Driver("Seriy"))));

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
