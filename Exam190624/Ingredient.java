package Ex2;

public class Ingredient {

    //campi
    private String name;
    private int quantity;

    public Ingredient(String name, int quantity) {

        this.name = name;
        this.quantity = quantity;
    }

    //Metodo per cambiare la quantità dell'Ingrediente
    public void setQuantity(int quantity) {this.quantity = quantity;}

    //Getters
    public String getName() {return name;}
    public String getQuantity() {return quantity + "g";}

    //Override del Metodo toString() per rappresentare correttamente gli Ingredienti
    @Override
    public String toString() {return name + "(" + getQuantity() + ")";}
}
