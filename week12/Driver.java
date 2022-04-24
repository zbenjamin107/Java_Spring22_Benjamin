public class Driver{

    public static void main(String[] args) {
        //demstrating a few instances of employee and what a no argument custrutor looks like compared to an overloaded custructor
        // arguments to create an employee
        Date born = new Date(6,4,2001);
        Date hired = new Date(4,19,2022);
        Person p = new Person("mike", "taylor","0123456789",born);
        // employee instances
        Employee e1 = new Employee();
        Employee e2 = new Employee(p,hired,45678,"food industry");
        // demostrate by printing
        System.out.println("\nInstance of an employee with no information given\n" + e1 + "notice every feture is null except for the ID, which has default value of 0\n");
        System.out.println("Emplyee with specifications:\n" + e2);


        // now to demostrate cutomer instances and prove inherited methods
        Date dateBorn = new Date(2,29,1976);
        Date dateJoined = hired; // im lazy. same date used for employee
        Person person = new Person("mike","Tyson","9876543210",dateBorn);
        // now to create a few customer instances
        Customer c1 = new Customer();
        Customer c2 = new Customer(person, dateJoined, "12345");
        Customer c3 = new Customer("Sara", "Woodened", "1236547890", new Date(4,24,2980),new Date(5,26,2003),"1a2b3d");
        //print statements
        System.out.println("\ninstance of a customer with no information given\n" + c1 + "notice every feture is unkown or null expecpt for date which has the default date\n");
        System.out.println("Customer with specifications:\n" + c2);


        //demonstrating an account instance
        Account account1 = new Account(1234 ,e2,c2,new Date(12,24,2020));
        Account account2 = new Account(246,c3,new Date(5,26,2003),50000.00);
        Account copy1 = new Account(1234 ,e2,c2,new Date(12,24,2020));
        //now to print some info
        System.out.println("\nInstances of accounts");
        System.out.println("ACCOUNT 1\n" + account1);
        System.out.println("\nACCOUNT 2\n" + account2);
        System.out.printf("Does account1 have the same values as accout2?? %b\n",account1.equals(account2));
        
    }
}