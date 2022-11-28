
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"молоко         ", "хлеб           ", "гречневая крупа"};
        int[] prices = {50, 14, 80};
        String[] basketProducts = new String[products.length];
        int[] contProducts = new int[products.length];
        int sum = 0;
        while (true) {

            System.out.println("Список возможных товаров для покупки");
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i] + " " + prices[i] + " рублей за шт.");
            }
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                String[] pars = input.split(" ");
                int productNumberPart1 = Integer.parseInt(pars[0]) - 1;
                int productCountPart2 = Integer.parseInt(pars[1]);
                int currentPrice = prices[productNumberPart1];
                sum += currentPrice * productCountPart2;
                String currentProduct = products[productNumberPart1];
                basketProducts[productNumberPart1] = currentProduct;
                contProducts[productNumberPart1] = productCountPart2 + contProducts[productNumberPart1];
            }
        }
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        for (int i = 0; i < basketProducts.length; i++) {
            if (basketProducts[i] != null) {
                System.out.println(basketProducts[i] + "           " + contProducts[i] + "           " + prices[i] + "            " + (prices[i] * contProducts[i]));
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("сумма покупки составит " + sum);
    }
}