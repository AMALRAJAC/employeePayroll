import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public static String PAYROLL_FILE_NAME="C:\\Users\\CRACKERJACK\\IdeaProjects\\JDBC_Demo\\src\\main\\java\\payroll-file.txt";
    public enum IOService{
        CONSOLE_IO,FILE_IO,DB_IO,REST_IO
    }
    private List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService(){}
    public  EmployeePayrollService(List<EmployeePayrollData>employeePayrollList){

    this.employeePayrollList=employeePayrollList;

    }
    public static void main(String[] args){
        ArrayList<EmployeePayrollData>employeePayrollList=new ArrayList<>();
        EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader=new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);

    }
    public void readEmployeePayrollData(Scanner consoleInputReader){
        System.out.println("Enter employee id");
        int id=consoleInputReader.nextInt();
        System.out.println("Employee name");
        String name=consoleInputReader.nextLine();
        System.out.println("Enter employee salary");
        double salary=consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));

    }
    public void writeEmployeePayrollData(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO)){
            System.out.println("\nWriting employee payroll Roaster to console\n"+employeePayrollList);
        }
        else if(ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollIOService().writeData(employeePayrollList);

        }
    }
    public long readEmployeePayrollData(IOService ioService){
        if(ioService.equals(IOService.FILE_IO)){
            this.employeePayrollList=new EmployeePayrollIOService().readData();

        }
        return employeePayrollList.size();
    }
    public void printData(IOService ioService){
        if(ioService.equals(IOService.FILE_IO)){
            new  EmployeePayrollIOService().printData();
        }
    }
    public static long countEntries(IOService ioService){
        long entries=0;
        try{
            entries= Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
