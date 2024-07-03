package Ex2;

public class SpicyIngredient extends Ingredient {

    //Chiamata al costruttore di Ingredient
    public SpicyIngredient(String name, int quantity) {super(name, quantity);}

    //Override del Metodo toString(), concatena "Spicy" e la Stringa di ritorno del Metodo
    //toString() di Ingredient, se ad Esempio avessi uno SpicyIngredient sp1 con campo nome = "Pepper"
    //e quantity = 9
    //sp1.toString() ritornerebbe "Spicy Peperoncino(9g)
    @Override
    public String toString() {return "Spicy " + super.toString();}
}
