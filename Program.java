package Seminar_2_hw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 */
public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        Animal[] animals = new Animal[]{
                new Cat("Барсик", 2, "Мяу"),
                new Dog("Шарик", 6, "Гав-гав"),
                new Cat("Мурзик", 5, "Мяу-мяу"),
                new Dog("Бобик", 3, "Гав"),
        };

        for (Animal animal : animals){
            information(animal);
        }

    }

    private static <Object> void information (Object object) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Информация о классе объекта: ");
        Class<?> objectClass = object.getClass();
        System.out.println(objectClass);



        System.out.println("Информация о полях объекта: ");
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(object));
        }

        Field[] superFields = objectClass.getSuperclass().getDeclaredFields();
        for (Field field : superFields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(object));
        }

        System.out.println("Вызов метода makeSound: ");
        Method makeSound = objectClass.getMethod("makeSound");
        makeSound.invoke(object);

        System.out.println();
        System.out.println();
    }
}
