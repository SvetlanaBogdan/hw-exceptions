package ru.netology;

// Класс товара
public class Product {

    protected int id;      // уникальный идентификатор товара
    protected String title; // название товара
    protected int price;    // цена товара

    // Конструктор для создания товара
    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // Переопределяем equals для корректного сравнения объектов
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        return title.equals(product.title);
    }

    // Переопределяем hashCode
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + price;
        return result;
    }

    // Геттер для id (понадобится в репозитории)
    public int getId() {
        return id;
    }
}