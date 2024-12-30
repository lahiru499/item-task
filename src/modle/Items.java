package modle;

public class Items {

    private String name;
    private String qty;
    private double price;
    private String Description;
    private String id;
    public Items(String name, String qty, double price, String description, String id) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        Description = description;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return Description;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price=" + price +
                ", Description='" +  + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}