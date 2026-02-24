package ru.netology;

// Собственное исключение,
// которое выбрасывается, если товар не найден
public class NotFoundException extends RuntimeException {

    // Конструктор принимает сообщение об ошибке
    public NotFoundException(String message) {
        super(message);
    }
}