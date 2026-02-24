package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    // Тест успешного удаления существующего товара
    @Test
    public void shouldRemoveExistingProduct() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Book", 100);
        Product product2 = new Product(2, "Phone", 500);
        Product product3 = new Product(3, "Laptop", 1000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        // Удаляем товар с id = 2
        repo.removeById(2);

        // Ожидаемый результат — массив без product2
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, repo.findAll());
    }


    // Тест выбрасывания исключения при удалении несуществующего id
    @Test
    public void shouldThrowNotFoundException() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Book", 100);

        repo.add(product1);

        // Проверяем, что выбрасывается наше исключение
        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.removeById(99)
        );
    }
}