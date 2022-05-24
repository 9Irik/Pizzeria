package runner;

import entity.Basket;
import entity.Client;
import org.hibernate.Session;

import java.util.List;
import java.util.Objects;

//3. Вывести время ожидания заказа пицц у клиентов

public class Task_3 {

    public static void Task_3(Session session) {

        List<Client> clients = session.createQuery("FROM Client").list();

        for (Client client : clients) {
            for (Basket basket : client.getBasket()) {
                if (Objects.equals(basket.getStatus(), "Ожидание")) {
                    System.out.println(client + " ожидает " + basket.getCatalog().getName() + " " + basket.getCatalog().getSize() + "\n" +
                            "Время готовки: " + basket.getCatalog().getKitchen().getTimeCook());
                }
            }
        }
    }
}
