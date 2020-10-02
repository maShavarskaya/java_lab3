import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Car");
        System.out.println();

        //Car[] cars_list = cars_list();          ///// ручное заполнение
        Car[] cars_list = car();             ////// автозаполнение
        System.out.println("----------a)Print List of the Cars of that model.");
        System.out.print("Enter model (marka) of a Car: ");
        check_mark(cars_list, scanner.next());

        System.out.println("----------b)Enter List of cars of a given model that have been in use for more than n years.");
        System.out.print("Enter a Model of a Car: ");
        String model = scanner.next();
        System.out.print("Enter Number of years of use: ");
        check_model(cars_list, model, scanner.nextInt());

        System.out.println("----------c)Print List of cars of the set year of release which price is more than the specified.");
        System.out.print("Enter A Year Of Manufacturing: ");
        int year = scanner.nextInt();
        System.out.print("Enter A Price:  ");
        check_year(cars_list, year, scanner.nextInt());

        scanner.close();

    }


        static Car[] cars_list () {
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Enter a number of cars: ");
            Car[] cars = new Car[scanner1.nextInt()];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car();
                System.out.println();
                System.out.print("Enter id: ");
                cars[i].setId(scanner1.nextInt());
                System.out.print("Enter brand: ");
                cars[i].setMarka(scanner1.next());
                System.out.print("Enter model: ");
                cars[i].setModel(scanner1.next());
                System.out.print("Enter a year of production: ");
                cars[i].setYear(scanner1.nextInt());
                System.out.print("Enter a color: ");
                cars[i].setColor(scanner1.next());
                System.out.print("Enter a price: ");
                cars[i].setPrice(scanner1.nextInt());
                System.out.print("Enter registration number: ");
                cars[i].setRegistration_number(scanner1.nextInt());
            }

            return cars;
        }

        static Car[] car () {
            Car[] cars = new Car[3];
            cars[0] = new Car(0, "BMV", "X5", 2005, "black", 2100, 2134);
            cars[1] = new Car(1, "Mazda", "X2", 2001, "white", 1500, 1649);
            cars[2] = new Car(2, "Toyota", "X2", 2009, "blue", 2990, 3452);


            return cars;
        }

        static void check_mark (Car[]cars, String marka){
            for (Car car : cars) {
                if (car.getMarka().equals(marka))
                    System.out.println(car.toString());
            }
            System.out.println();
        }

        static void check_model (Car[]cars, String model,int n){
            for (Car car : cars) {
                if (car.getModel().equals(model) && (2020 - car.getYear()) > n) {
                    System.out.println(car.toString());
                }
            }
            System.out.println();
        }

        static void check_year (Car[]cars,int year, int price){
            for (Car car : cars) {
                if (car.getYear() == year && car.getPrice() > price)
                    System.out.println(car.toString());
            }
        }
    }