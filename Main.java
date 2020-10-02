import java.util.*;
import java.util.List;

class Main {
    public static void main(String[] args) {

        Car.addCar(new Car("audi", "A6", 2006, "YELLOW", 12500.50, "G 125S F"));
        Car.addCar(new Car("audi", "A8", 2008, "RED", 15300., "K 183L G"));
        Car.addCar(new Car("bmw", "3", 2006, "YELLOW", 14000., "H 444J K"));
        Car.addCar(new Car("bmw", "3", 2005, "YELLOW", 14000., "H 444J K"));
        Car.addCar(new Car("bmw", "7", 2002, "BLACK", 10400., "Y Y15R Q"));
        Car.addCar(new Car("VW", "Polo", 2009, "GRAY", 11500., "F 189N C"));

        System.out.println("Список автомобилей заданной марки");
        Car.filterCar1("audi");
        System.out.println("Список автомобилей заданной модели, которые эксплуатируются больше n лет");
        Car.filterCar2("3", 5);
        System.out.println("Список автомобилей заданного года выпуска, цена которых больше указанной");
        Car.filterCar3(2006, 10000.40);
    }
}

class Car {
    private static List<Car> listCar = new LinkedList<Car>();
    private int id;
    private String brand;
    private String model;
    private long year;
    private String color;
    private long cost;
    private String registrationNo;

    public Car(String brand, String model, int year, String color, double cost, String registrationNo) {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setColor(color);
        setCost(cost);
        setRegistrationNo(registrationNo);
    }

    private static int getCurrentYear() {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }


    public static void addCar(Car currentCar) {
        listCar.add(currentCar);
    }

    private static void print(Car currentCar) {
        System.out.println(currentCar);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", year=").append(year);
        sb.append(", color='").append(color).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", registrationNo='").append(registrationNo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public double getCost() {
        return (double) cost / 100;
    }

    public void setCost(double cost) {
        this.cost = (long) (cost * 100);
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public static void filterCar1(String brand) {
        for (Car currentCar : listCar) {
            if (currentCar.getBrand().equals(brand)) {
                print(currentCar);
            }
        }
    }

    public static void filterCar2(String model, int cntYear) {
        for (Car currentCar : listCar) {
            if (currentCar.getModel().equals(model) && (getCurrentYear() - currentCar.getYear()) > cntYear) {
                print(currentCar);
            }
        }
    }

    public static void filterCar3(int year, double price) {
        for (Car currentCar : listCar) {
            if (currentCar.getYear() == year && currentCar.getCost() > price) {
                print(currentCar);
            }
        }
    }
}

