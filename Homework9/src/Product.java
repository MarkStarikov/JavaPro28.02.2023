import java.time.LocalDate;

public class Product {
    private int identifier;
    private String type;
    private int price;
    private boolean discount;
    private LocalDate createDate;


    public Product(int identifier, String type, int price, boolean discount, LocalDate createDate) {
        this.identifier = identifier;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return  "\nProduct{" +
                "identifier=" + identifier +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                "}";
    }
}
