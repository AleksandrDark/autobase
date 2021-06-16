package console;

import domain.Car;
import service.CarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CarConsoleOutput {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final CarService carService = new CarService();

    public void outputAllCar(){
        List<Car> cars = carService.getAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void outputGetCar(Integer id){
        System.out.println(carService.getID(id));
    }

    public void outputCreateCar(Car car){
        System.out.println(carService.create(car));
    }

    public void outputUpdateCar(Integer id, Car car){
        System.out.println(carService.update(id, car));
    }

    public void outputDeleteCar(Integer id){
        System.out.println(carService.deleteID(id));
    }

    public void intoParseCarDB() throws IOException {
        String userInput = reader.readLine();
        String[] carInfo = userInput.split(" ");
        if (carInfo.length == 2){
            String model = carInfo[0];
            String number = carInfo[1];
            outputCreateCar(new Car(model, number));
        }else if (carInfo.length == 3){
            Integer id = Integer.parseInt(carInfo[0]);
            String model = carInfo[1];
            String number = carInfo[2];
            outputUpdateCar(id, new Car(model, number));
        }
    }

}
