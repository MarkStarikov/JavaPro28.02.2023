import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final int DISCOUNTER = 10;

    public static void main(String[] args) {

        List<Product> printedGoods = Stream.of(new Product(50454, "book", 400, true, LocalDate.of(2019, 2, 22)),
                        new Product(50455, "magazine", 300, false, LocalDate.of(2023, 1, 22)),
                        new Product(50456, "postcard", 100, false, LocalDate.of(2019, 2, 23)),
                        new Product(50457, "book", 240, true, LocalDate.of(2023, 2, 27)),
                        new Product(50458, "postcard", 100, false, LocalDate.of(2019, 11, 21)),
                        new Product(50459, "book", 290, true, LocalDate.of(2018, 4, 2)),
                        new Product(50453, "notebook", 120, false, LocalDate.of(2021, 7, 21)),
                        new Product(50452, "book", 60, false, LocalDate.of(2023, 2, 12)),
                        new Product(50451, "postcard", 200, false, LocalDate.of(2023, 2, 27)),
                        new Product(50450, "magazine", 400, false, LocalDate.of(2020, 9, 22)),
                        new Product(50449, "book", 30, false, LocalDate.of(2023, 2, 20)),
                        new Product(50448, "book", 50, true, LocalDate.of(2023, 2, 21)),
                        new Product(50447, "postcard", 40, false, LocalDate.of(2019, 2, 22)),
                        new Product(50446, "magazine", 320, false, LocalDate.of(2019, 2, 22)),
                        new Product(50445, "book", 230, false, LocalDate.of(2019, 2, 22)),
                        new Product(50444, "notebook", 100, false, LocalDate.of(2019, 2, 22)),
                        new Product(50443, "book", 220, false, LocalDate.of(2019, 2, 22)),
                        new Product(50442, "book", 500, true, LocalDate.of(2022, 5, 12)),
                        new Product(50441, "book", 200, true, LocalDate.of(2018, 3, 12)),
                        new Product(50440, "postcard", 40, false, LocalDate.of(2017, 5, 22)))

                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(getGoodsByPrice(printedGoods, "book", 250));
        System.out.println(getDiscountedBook(printedGoods, "book"));
        System.out.println(getTheCheapestBook(printedGoods, "book"));
        System.out.println(getThreeLastAddedGoods(printedGoods));
        System.out.println(getsSumPriceGoods(printedGoods, "book", 75));
        System.out.println(convertToMap(printedGoods));

    }
    public static List<Product> getGoodsByPrice(List<Product> printedGoods, String type, int price) {
        return printedGoods.stream()
                .filter(g -> g.getType().equals(type) && g.getPrice() > price)
                .toList();

    }

    public static List<Product> getDiscountedBook(List<Product> printedGoods, String type) {
        return printedGoods.stream()
                .filter(g -> g.getType().equals(type) && g.isDiscount())
                .peek(p -> p.setPrice(p.getPrice() -(p.getPrice()/DISCOUNTER)))
                .toList();

    }

    public static Product getTheCheapestBook(List<Product> printedGoods, String type) throws NoSuchElementException {

        return printedGoods.stream()
                .filter(g -> g.getType().equals(type))
                .min(Comparator.comparingInt(Product::getPrice))
                .orElseThrow();


        }


    public static List<Product> getThreeLastAddedGoods(List<Product> printedGoods) {
        return printedGoods.stream()
                .sorted((Comparator.comparing(Product::getCreateDate)))
                .skip(printedGoods.size()-3)
                .toList();

    }
    public static int getsSumPriceGoods(List<Product> printedGoods, String type, int price) {
        return printedGoods.stream()
                .filter(c -> c.getType().equals(type) && c.getPrice() <= price)
                .filter(d -> d.getCreateDate().getYear() == LocalDate.now().getYear())
                .mapToInt(Product::getPrice)
                .sum();

    }
    public static Map<String, List <Product>> convertToMap(List<Product> printedGoods) {
        return printedGoods.stream()
                .collect(Collectors.groupingBy(Product::getType));

    }
}
