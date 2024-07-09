package Data;


public class OrderItem {
    private int idItem;
    private int idOrder;
    private int idPizza;
    private Double quantity;
    private Double price;

    public OrderItem(int idItem, int idOrder, int idPizza, Double quantity, Double price) {
        this.idItem = idItem;
        this.idOrder = idOrder;
        this.idPizza = idPizza;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
