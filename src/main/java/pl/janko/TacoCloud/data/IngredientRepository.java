package pl.janko.TacoCloud.data;

import pl.janko.TacoCloud.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);

}
