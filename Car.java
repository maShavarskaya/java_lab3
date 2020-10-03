import java.util.LinkedList;
import java.util.List;

public class Car {
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

    public static void filterCarByBrand(String brand) {
        for (Car currentCar : listCar) {
            if (currentCar.getBrand().equals(brand)) {
                print(currentCar);
            }
        }
    }

    public static void filterCarByModelAndYear(String model, int cntYear) {
        for (Car currentCar : listCar) {
            if (currentCar.getModel().equals(model) && (getCurrentYear() - currentCar.getYear()) > cntYear) {
                print(currentCar);
            }
        }
    }

    public static void filterCarByYearAndCost(int year, double price) {
        for (Car currentCar : listCar) {
            if (currentCar.getYear() == year && currentCar.getCost() > price) {
                print(currentCar);
            }
        }
    }
}
