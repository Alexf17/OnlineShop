package com.example.onlineshop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Category {
    private UUID id;
    private String name;
    private String description;
    private long parentCategory;

    public Category() {
    }

    public Category(String name, String description, long parentCategory) {
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parentCategory=" + parentCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (parentCategory != category.parentCategory) return false;
        if (!id.equals(category.id)) return false;
        if (!name.equals(category.name)) return false;
        return description.equals(category.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (int) (parentCategory ^ (parentCategory >>> 32));
        return result;
    }
}
