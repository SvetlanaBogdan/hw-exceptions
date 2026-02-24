package ru.netology;

// Репозиторий для хранения товаров
public class ShopRepository {

    private Product[] products = new Product[0]; // массив товаров

    // Метод добавления товара
    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    // Метод возвращает все товары
    public Product[] findAll() {
        return products;
    }

    // Метод удаления по id с выбрасыванием исключения
    public void removeById(int id) {

        // Проверяем, существует ли товар
        Product existing = findById(id);

        if (existing == null) {
            // Если товар не найден — выбрасываем своё исключение
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        // Если найден — создаём новый массив без этого элемента
        Product[] tmp = new Product[products.length - 1];
        int copyIndex = 0;

        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyIndex] = product;
                copyIndex++;
            }
        }

        products = tmp;
    }

    // Метод поиска товара по id
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // если не найден
    }
}