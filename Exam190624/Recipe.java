package Ex2;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Recipe {

    //Enumerazione delle difficoltà così da obbligare l'utilizzatore del software a scegliere fra queste 3
    public enum Difficulty {

        EASY("Easy"), NORMAL("Normal"), HARD("Hard");

        private final String difficulty;
        Difficulty(String difficulty) {this.difficulty = difficulty;}
        public String getDifficulty() {return difficulty;}
    }

    //Enumerazione delle Tipologie di Ricette così da obbligare l'utilizzatore del software a scegliere fra queste 2
    public enum Type {

        VEGAN("Vegan"), NON_VEGAN("Non Vegan");

        private final String type;
        Type(String type) {this.type = type;}
        public String getType() {return type;}
    }

    //campi
    private String name;
    private Difficulty difficulty;
    private Type type;
    private List<Ingredient> ingredients;
    private String recipeGuide;

    //costruttore di Recipe privato così da obbligare l'utilizzatore del software a costruire
    //le istanze di Recipe utilizzando la sua Classe Builder
    private Recipe(String name, Difficulty difficulty, Type type,
                   List<Ingredient> ingredients, String recipeGuide) {

        this.name = name;
        this.difficulty = difficulty;
        this.type = type;
        this.ingredients = ingredients;
        this.recipeGuide = recipeGuide;
    }

    //Getters
    public String getName() {return name;}
    public Difficulty getDifficulty() {return difficulty;}
    public Type getType() {return type;}
    public List<Ingredient> getIngredients() {return ingredients;}
    public String getRecipeGuide() {return recipeGuide;}

    //Override del metodo toString() per rappresentare correttamente le Ricette
    @Override
    public String toString() {return name + " Recipe";}

    //classe BUILDER
    public static class RecipeBuilder {

        private String name;
        private Difficulty difficulty;
        private Type type;
        private List<Ingredient> ingredients;
        private String recipeGuide;

        //inizializzo ingredients nel Costruttore, così da poter aggiungere e rimuovere ingredienti a piacimento
        public RecipeBuilder() {ingredients = new ArrayList<>();}

        //setters
        public RecipeBuilder setName(String name) {this.name = name;
        return this;}
        public RecipeBuilder setDifficulty(Difficulty difficulty) {this.difficulty = difficulty;
        return this;}
        public RecipeBuilder setType(Type type) {this.type = type;
        return this;}
        public RecipeBuilder addIngredient(Ingredient ingredient) {ingredients.add(ingredient);
        return this;}
        public RecipeBuilder removeIngredient(Ingredient ingredient) {ingredients.remove(ingredient);
        return this;}
        public RecipeBuilder setRecipeGuide(String recipeGuide) {this.recipeGuide = recipeGuide;
        return this;}

        //metodo build(), che lancia una InvalidParameterException quando i parametri obbligatori non
        //sono stati definiti, per evitare che vengano create istanze di Recipe con parametri essenziali mancanti
        public Recipe build() throws InvalidParameterException {

            if (name == null) throw
            new InvalidParameterException("Recipes must have a name!");

            if (ingredients.isEmpty()) throw
            new InvalidParameterException("Recipes must list at least 1 ingredient!");

            if (type == null) throw
            new InvalidParameterException("Recipes must be stated either Vegan or Non Vegan!");

            return new Recipe(name, difficulty, type, ingredients, recipeGuide);
        }
    }
}
