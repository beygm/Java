package Data;

import java.math.BigDecimal;



public class Pizza {
    private int idPizza;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean vegetarian;
    private boolean vegan;
    private boolean available;

    public Pizza(int idPizza, String name, String description, BigDecimal price, boolean vegetarian, boolean vegan, boolean available) {
        this.idPizza = idPizza;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.available = available;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
