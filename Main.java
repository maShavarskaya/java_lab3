//Задание не 03.10.2020
// Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер. Создать массив объектов.

class Main {
    public static void main(String[] args) {

        Car.addCar(new Car("Tesla", "Y", 2014, "Black", 25500.50, "G 125S F"));
        Car.addCar(new Car("audi", "A8", 2008, "RED", 15300., "K 183L G"));
        Car.addCar(new Car("bmw", "3", 2006, "YELLOW", 14000., "H 444J K"));
        Car.addCar(new Car("bmw", "3", 2005, "YELLOW", 14000., "H 444J K"));
        Car.addCar(new Car("bmw", "7", 2002, "BLACK", 10400., "Y Y15R Q"));
        Car.addCar(new Car("Tesla", "S", 2012, "GRAY", 11500., "F 189N C"));

        //a) список автомобилей заданной марки;
        System.out.println("Список автомобилей заданной марки");
        Car.filterCarByBrand("Tesla");
        //b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
        System.out.println("Список автомобилей заданной модели, которые эксплуатируются больше n лет");
        Car.filterCarByModelAndYear("S", 5);
        //c) список автомобилей заданного года выпуска, цена которых больше указанной.
        System.out.println("Список автомобилей заданного года выпуска, цена которых больше указанной");
        Car.filterCarByYearAndCost(2006, 10000.40);
    }
}
