package Qly_NhanSu;

import java.util.Scanner;

public class Human {
    private String name;         //ho va ten
    private int age;             //tuoi
    private String gender;     //gioi tinh
    private Address new_Address; //dia chi

    Scanner cin = new Scanner(System.in);
    Scanner gets = new Scanner(System.in);
    Scanner cdou = new Scanner(System.in);
    
    //Bo khoi tao
    public Human() {
        
    }
    
    public Human(String name, int age, String gender, Address new_Address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.new_Address = new_Address;
    }

    //cac ham get set 
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Address getAdd() {
        return new_Address;
    }

    public void setAdd(Address new_Address) {
        this.new_Address = new_Address;
    }    
    
    //Sua doi thong tin con nguoi
    public void setInfo(){
        System.out.println("Enter the name ");
        this.setName(gets.nextLine());
        System.out.println("Enter the age ");
        this.setAge(cin.nextInt());
        System.out.println("Enter the gender");
        this.setGender(gets.nextLine());
        //tao 1 bien nhap thong tin
        Address add = new Address();
        add.setInfo(); // nhap thong tin dia chi
        this.setAdd(add); // lay thong tin dia chi
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", new_Address=" + new_Address.toString() + '}';
    }
    
   
}
