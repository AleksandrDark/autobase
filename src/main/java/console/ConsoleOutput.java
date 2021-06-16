package console;

import domain.Driver;
import service.M2MDriverCarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleOutput {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final DriverConsoleOutput driverConsoleOutput = new DriverConsoleOutput();
    private final CarConsoleOutput carConsoleOutput = new CarConsoleOutput();

    public void startMethodOutput() {
        while (true) {
            System.out.printf("%s%s%s%s%s%n", "Выберите команду:\n", "Таблица drivers ---1\n",
                    "Таблица cars ---2\n", "Общая таблица ---3\n", "Закончить работу --4");
            try {
                int userInputTables = Integer.parseInt(reader.readLine());
                if (userInputTables == 1){
                    outputMethodDriver();
                }else if (userInputTables == 2){
                    outputMethodCar();
                }else if(userInputTables == 3){
                    outputCommonTable();
                }else if (userInputTables == 4){
                    break;
                }else{
                    System.out.println("Ошибка ввода, выберите один из предложенных вариантов");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputMethodDriver(){
        while (true) {
            System.out.println("Выберите команду: \nВыбрать всех водителей ---1\nДобавить нового водителя ---2\n" +
                                "Обновить данные по водителю ---3\nВыбрать водителя по id ---4\nУдалить водителя ---5\n" +
                                "Закончить работу, введите ---6");
            try {
                String userInput = reader.readLine();
                int command = Integer.parseInt(userInput);
                if (command == 1) {
                    driverConsoleOutput.outputAllDriver();
                } else if (command == 2) {
                    System.out.println("Введите данные водителя в формате \"name surname salary\"");
                    driverConsoleOutput.intoParseDriverDB();
                } else if (command == 3) {
                    System.out.println("Введите данные водителя в формате \"id name surname salary\"");
                    driverConsoleOutput.intoParseDriverDB();
                } else if (command == 4) {
                    System.out.println("Введите ID водителя:");
                    Integer id = Integer.parseInt(reader.readLine());
                    driverConsoleOutput.outputGetID(id);
                } else if (command == 5) {
                    System.out.println("Введите ID водителя:");
                    Integer id = Integer.parseInt(reader.readLine());
                    driverConsoleOutput.outputDeleteID(id);
                } else if (command == 6) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputMethodCar(){
        while (true){
            System.out.println("Выберите команду: \nВыбрать все машины ---1\nДобавить новую машину ---2\n" +
                                "Обновить данные по машине ---3\nВыбрать машину по id ---4\nУдалить машину ---5\n" +
                                "Закончить работу, введите ---6");
            try {
                String userInput = reader.readLine();
                int command = Integer.parseInt(userInput);
                if (command == 1) {
                    carConsoleOutput.outputAllCar();
                }else if (command == 2){
                    System.out.println("Введите данные машины в формате \"model number\"");
                    carConsoleOutput.intoParseCarDB();
                }else if (command == 3){
                    System.out.println("Введите данные машины в формате \"id model number\"");
                    carConsoleOutput.intoParseCarDB();
                }else if (command == 4) {
                    System.out.println("Введите ID машины:");
                    Integer id = Integer.parseInt(reader.readLine());
                    carConsoleOutput.outputGetCar(id);
                } else if (command == 5) {
                    System.out.println("Введите ID машины:");
                    Integer id = Integer.parseInt(reader.readLine());
                    carConsoleOutput.outputDeleteCar(id);
                } else if (command == 6) {
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void outputCommonTable(){
        M2MDriverCarService m2MDriverCarService = new M2MDriverCarService();
        System.out.println(m2MDriverCarService.getAllDriverCar());
    }
}
