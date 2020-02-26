

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */

import com.types.Employee;

public class Hello {

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param args
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello this is Osho!");

        System.out.println("Instance count=" + Employee.getInstances());

        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Osho");
        emp.setSalary(800000000);
        System.out.println("Id=" + emp.getId());
        System.out.println("Salary=" + emp.getSalary());
        System.out.println("Name=" + emp.getName());

        Employee emp1 = new Employee(2, "Rich", 23000);
        System.out.println("Id=" + emp1.getId());
        System.out.println("Salary=" + emp1.getSalary());
        System.out.println("Name=" + emp1.getName());
        System.out.println("Instance count=" + Employee.getInstances());


        emp = emp1 = null; // gets printed two times because two objects

        System.gc();


        try { // wait a bit so that the garbage collector is able to clear the
              // memory and decrements the count variable
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Instance count=" + Employee.getInstances());

    }

}
