import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private String name;
    private Integer salary;
    private Date startDate;

    public Employee(String name, Integer salary, Date startDate) {
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return name + " - " + salary + " - "
                + (new SimpleDateFormat("dd.mm.yyyy").format(startDate));
    }
}
