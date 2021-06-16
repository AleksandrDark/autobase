package console;

import domain.Driver;
import service.DriverService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DriverConsoleOutput {

        private final DriverService driverService = new DriverService();
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void outputAllDriver(){
        List<Driver> driverList = driverService.getAll();
        for (Driver driver : driverList) {
            System.out.println(driver);
        }
    }

    public void outputGetID(Integer id){
        System.out.println(driverService.get(id));
    }

    public void outputInsert(Driver driver){
        System.out.println(driverService.create(driver));
    }

    public void outputUpdate(Integer id, Driver driver){
        System.out.println(driverService.update(id, driver));
    }

    public void outputDeleteID(Integer id){
        System.out.println(driverService.deleteID(id));
    }

    public void intoParseDriverDB() throws IOException {
        String userInput = reader.readLine();
        String[] driverInfo = userInput.split(" ");
        if (driverInfo.length == 3){
            String name = driverInfo[0];
            String surname = driverInfo[1];
            Integer salary = Integer.parseInt(driverInfo[2]);
            outputInsert(new Driver(name, surname, salary));
        }else if (driverInfo.length == 4){
            Integer id = Integer.parseInt(driverInfo[0]);
            String name = driverInfo[1];
            String surname = driverInfo[2];
            Integer salary = Integer.parseInt(driverInfo[3]);
            outputUpdate(id, new Driver(name, surname, salary));
        }
    }
}
