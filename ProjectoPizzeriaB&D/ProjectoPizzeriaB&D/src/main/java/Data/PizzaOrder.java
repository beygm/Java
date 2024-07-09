package Data;

import java.time.LocalDateTime;


public class PizzaOrder {
    private int idOrder;
    private String idCustomer;
    private LocalDateTime date;
    private String status;

    public PizzaOrder(int idOrder, String idCustomer, LocalDateTime date, String status) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.date = date;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
