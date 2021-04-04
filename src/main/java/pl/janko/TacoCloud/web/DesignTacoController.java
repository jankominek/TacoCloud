package pl.janko.TacoCloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.janko.TacoCloud.Ingredient;
import pl.janko.TacoCloud.Ingredient.Type;
import pl.janko.TacoCloud.Taco;
import pl.janko.TacoCloud.data.IngredientRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {


    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


    @GetMapping
    public String showDesignForm(Model model){
            List<Ingredient> ingredients = new ArrayList<>();
            ingredientRepo.findAll().forEach(ingredient -> ingredients.add(ingredient));

        //        List<Ingredient> ingredients = Arrays.asList(
//            new Ingredient("FLTO", "pszena", Type.WRAP),
//            new Ingredient("COTO", "kukurydziana", Type.WRAP),
//            new Ingredient("GRBF", "mielona wolowina", Type.PROTEIN),
//            new Ingredient("CARN", "kawalki miesa", Type.PROTEIN),
//            new Ingredient("TMTO", "pomidory pokrojone w kostke", Type.VEGGIES),
//            new Ingredient("LETC", "salata", Type.VEGGIES),
//            new Ingredient("CHED", "cheddar", Type.CHEESE),
//            new Ingredient("JACK", "Montery jack", Type.CHEESE),
//            new Ingredient("SLSA", "pikantny sos pomidorowy", Type.SAUCE),
//            new Ingredient("SRCR", "smietana", Type.SAUCE)
//        );
        Type[] types = Ingredient.Type.values();
        for(Type type : types){
            System.out.println(type);
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors){
        if(errors.hasErrors()){
            return "design";
        }
        log.info("Przetwarzanie obiektu Taco design... " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
