import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NIOTest {
    @Test
    public  void given3EmployeesWhenWrittenToFilesShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "jeff bezos", 10000.0),
                new EmployeePayrollData(2, "Bill gates", 20000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 30000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService=new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries=EmployeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,entries);
    }
    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        long entries=employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,entries);
    }
}
