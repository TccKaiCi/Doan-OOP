package Qly_NhanSu;

import java.io.IOException;

public class Emp_Hafl extends Employee{
    
    
    public Emp_Hafl() {
        this.setCategorize(" ");
    }
    
    public Emp_Hafl(String id, double salary, int id_room, String position, String name, int age, String genus, Address new_Address) {
        super(id," ", salary, id_room, position, name, age, genus, new_Address);
    }

    @Override
    public double calWages() throws IOException{
        return super.getSalary() * saraly.calWages(super.getPosition());
    }
}
