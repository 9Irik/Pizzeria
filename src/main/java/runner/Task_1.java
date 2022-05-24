package runner;

import entity.Catalog;
import org.hibernate.Session;

import java.util.List;

//1. Вывести самую дешёвую пиццу в каталоге

public class Task_1 {

    public static void Task_1(Session session) {

        List<Catalog> catalogs = session.createQuery("FROM Catalog").list();

        double min = 1000000;
        String pizza = null;

        for (Catalog catalog : catalogs) {
            if (catalog.getPrice() < min) {
                min = catalog.getPrice();
                pizza = "Пицца " + catalog.getName() + ", " + catalog.getSize();
            }
        }

        System.out.println("Самая дешёвая пицца: \n" +
                pizza + "\n" +
                "Стоимость: " + min);
    }
}
