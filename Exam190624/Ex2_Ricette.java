package Ex2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Ex2_Ricette implements Iterable {

    //campi
    private static Ex2_Ricette instance;
    private List<Recipe> recipes;

    //Strategy Pattern, funzioni Lambda usate per il metodo modifyRecipe
    //così da facilitare l'estensione del software nel caso in cui si dovessero aggiungere
    //altri modi di modificare le Ricette.
    //Dato che può esistere solo 1 istanza della classe, anche senza essere campi static, l'implementazione
    //non dovrebbe causare problemi.
    public final BiFunction<Recipe, Recipe, Recipe>
    SUBSTITUTE_RECIPE = (oldRecipe, newRecipe) -> {
        recipes.set(recipes.indexOf(oldRecipe), newRecipe);
        return newRecipe;
    };

    //Costruttore privato (Singleton Pattern)
    private Ex2_Ricette(List<Recipe> recipes) {this.recipes = recipes;}

    //metodo getInstance per assicurarsi che esista solo 1 istanza della Classe
    public static Ex2_Ricette getInstance(List<Recipe> recipes) {

        if (instance == null) instance = new Ex2_Ricette(recipes);
        return instance;
    }

    //Metodi per ottenere l'iteratore della lista di Ricette, per aggiungere e rimuovere Ricette
    @Override
    public Iterator<Recipe> iterator() {return recipes.iterator();}

    public void addRecipe(Recipe recipe) {recipes.add(recipe);}
    public void removeRecipe(Recipe recipe) {recipes.remove(recipe);}

    //metodo modifyRecipe che prende come argomenti due ricette e la funzione tramite la quale vengono operate
    public Recipe modifyRecipe(Recipe recipe1, Recipe recipe2, BiFunction<Recipe, Recipe, Recipe> function) {
        return function.apply(recipe1, recipe2);
    }

    public Map<Recipe.Type, List<Recipe>> getMappaTipologiaRicette() {

        //uso una method Reference per raggruppare tutte le Ricette per Tipologia
        return recipes
                .stream()
                .collect(Collectors.groupingBy(Recipe::getType));
        //ritorna una Mappa che fa uso di HashTable
    }

    public  Map<String, List<String>> getHashMappaIngredientiQuantitaPerTipologiaRicetta(Recipe.Type type) {

        return recipes
                .stream()
                //filtro le ricette, prendendo solo quelle che hanno la stessa Tipologia del type in ingresso
                .filter(recipe -> recipe.getType().equals(type))
                //uso flatMap per creare un unico stream con tutti gli Ingredienti delle Ricette
                .flatMap(recipe -> recipe.getIngredients().stream())
                //Colleziono in una mappa: le chiavi sono i nomi degli Ingredienti,
                //I valori sono liste, in cui ci sono le quantità dell'Ingrediente
                .collect(Collectors.groupingBy(Ingredient::getName,
                                            Collectors.mapping(Ingredient::getQuantity, Collectors.toList())
                ));
        //ritorna una Mappa che fa uso di HashTable
    }
}
