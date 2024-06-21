package com.bonappetit.init;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.enums.CategoriesEnum;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitService implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final Map<CategoriesEnum, String> categoriesMap;
    

    public InitService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        categoriesMap = Map.of(
                CategoriesEnum.COCKTAIL, "Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.",
                CategoriesEnum.DESSERT,  "Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.",
                CategoriesEnum.MAIN_DISH, "Heart of the meal, substantial and satisfying; main dish delights taste buds.");
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() <= 0) {

            System.out.println("saving data...");

            categoriesMap.entrySet().forEach(set -> categoryRepository.save(new Category(set.getKey(), set.getValue())));
            
        }

    }
}
