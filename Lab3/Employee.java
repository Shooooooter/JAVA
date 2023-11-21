class Employee implements Comparable<Employee> {
    private int Emp_id;
    private String Emp_Name;
    private String Emp_gender;
    private int Year_of_Joining;
    private double Salary;
    private String Department;
     

    public Employee(int Emp_id, String Emp_Name, String Emp_gender, int Year_of_Joining, double Salary,
            String Department) {
        this.Emp_id = Emp_id;
        this.Emp_Name = Emp_Name;
        this.Emp_gender = Emp_gender;
        this.Year_of_Joining = Year_of_Joining;
        this.Salary = Salary;
        this.Department = Department;
    }

    public int getYear_of_Joining() {
        return Year_of_Joining;
    }

    @Override
    public int compareTo(Employee other) {
        return this.Year_of_Joining - other.getYear_of_Joining();
    }

    @Override
    public String toString() {
        return "Employee ID: " + Emp_id +
                "\nEmployee Name: " + Emp_Name +
                "\nGender: " + Emp_gender +
                "\nYear of Joining: " + Year_of_Joining +
                "\nSalary: $" + Salary +
                "\nDepartment: " + Department + "\n";
    }

}