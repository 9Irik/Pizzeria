package runner;

import entity.Kitchen;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

//2. Найти ингредиенты в составе пицц

public class Task_2 {

    public static void Task_2(Session session) {

        List<Kitchen> kitchens = session.createQuery("FROM Kitchen").list();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите искомый ингредиент: ");
        String enter = scanner.nextLine();

        String string;

        for (Kitchen kitchen : kitchens) {
            string = kitchen.getInfo();
            if (string.contains(enter)) {
                System.out.println(kitchen);
            }
        }
    }
}
