package kz.pinemelon.controller;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins="http://localhost:8080")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}/categories")
    public List<Category> getAll(@PathVariable("id") Category category) {
        return categoryService.listByCategory(category);
    }

    @GetMapping
    List<Category> getAll() {
        return categoryService.list();
    }

    @GetMapping("{id}")
    public Category get(
            @PathVariable("id") Category category){
        return category;
    }

    @PostMapping
    public Category create(
            @RequestBody Category category
    ) {
        return categoryService.create(category);
    }

    @PutMapping("{id}")
    public Category update(
            @PathVariable("id") Category categoryFromDB,
            @RequestBody Category category
    ){
        return categoryService.update(categoryFromDB, category);
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") Category category){
        categoryService.delete(category);
    }
}
