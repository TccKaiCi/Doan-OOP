package Qly_NhanSu;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Employee extends Human{
    private String id;          //id duy nhat
    private double salary;      //luong
    private String position;    //chuc vu
    private int id_room;        //ma phong
    private String categorize;  //loai nhan vien
    protected Saraly saraly = new Saraly();
    
    //bo khoi tao
    public Employee(){
        
    }

    public Employee(String id,String categorize, double salary, int id_room, String position, String name, int age, String genus, Address new_Address) {
        super(name, age, genus, new_Address);
        this.id = id;
        this.salary = salary;
        this.id_room = id_room;
        this.position = position;
    }
    
    //cac ham set get 
    public String getCategorize() {
        return categorize;
    }

    public void setCategorize(String categorize) {
        this.categorize = categorize;
    }
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }
            
    //Lay thong tin nguoi di lam
    @Override
    public void setInfo(){
        //nhap thong tin ve nguoi
        //goi ham nhap tu superclass (Person)
        super.setInfo();
        //nhap thong tin cua nguoi di lam
        //System.out.println("Enter the id ");
       // this.setId(gets.nextLine());
        System.out.println("Enter the id_room ");
        this.setId_room(cin.nextInt());
        System.out.println("Enter the salary ");
        this.setSalary(cdou.nextDouble());
        System.out.println("Enter the position ");
        this.setPosition(gets.nextLine());
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", salary=" + salary + ", position=" + position + ", id_room=" + id_room + '}';
    }
    
    public void display(){
        System.out.println(" _________________________________________________________________________________________________________________________________________________________");
        //                         1          2            3           4               5            6           7                 8              9               10         11
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   GIOI TINH  | Full Time |  Ma_Phong  |    CHUC VU    |   LUONG   |     PHUONG    |     QUAN     |    THANH_PHO   |");
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.printf( 
            //   1     2       3     4         5        6      7      8       9    10        11
                    "| %-9s| %-14s|  %-8d|     %-8s |    %-5s  |  %-9d | %-14s|  %-9s| %-14s| %-13s| %-15s| \n"
            , this.getId(), super.getName()             // 1   2
            , super.getAge() , super.getGender()        // 3   4
            , this.getCategorize() , this.getId_room()  // 5    6
            , this.getPosition() ,this.getSalary()      // 7    8
            , super.getAdd().getWard()                  // 9   
            , super.getAdd().getDistrict()              // 10   
            , super.getAdd().getCity()                  // 11
        );
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
    }
    
    public void writeFile(BufferedWriter out) throws IOException{
        try {
            // khi viet file viet them dau | vao giua
            out.write(super.getName() + "|");
            out.write(String.valueOf(super.getAge()) + "|");
            out.write(super.getGender() + "|");
            out.write(super.getAdd().getWard() + "|");
            out.write(super.getAdd().getDistrict() + "|");
            out.write(super.getAdd().getCity() + "|");
            out.write(this.getId() + "|");
            out.write(String.valueOf(this.getId_room()) + "|");
            out.write(this.getPosition() + "|");
            out.write(this.getSalary() + "|");  
            out.write(this.getCategorize() + "|");
            out.newLine();
        } catch (Exception e) {
            System.out.println("Error in writing ");
        }
    }
    
    public boolean readFile(String s){ 
        if (s!=null){
            // khi doc file doc toi dau |
            String[] inp = s.split("\\|");
            super.setName(inp[0]);
            super.setAge( Integer.parseInt( inp[1] ) );
            super.setGender(inp[2]);
            super.setAdd(new Address(inp[3],inp[4],inp[5]));
            this.setId(inp[6]);
            this.setId_room( Integer.parseInt(inp[7]));
            this.setPosition(inp[8]);
            this.setSalary(Double.parseDouble(inp[9]));
            this.setCategorize(inp[10]);
            return true;
        }
        return false;
    }
    
    public String setFull_Hafl() throws IOException{
            String s = (super.getName() 
                    + " have id: " + this.getId() 
                    + " from Fulltime"
                    + " to Parttime");
            this.setCategorize(" ");
            //s = s.concat("\n");
        return s;
    }
    
    public String setHafl_Full() throws IOException{
            String s = (super.getName() 
                    + " have id: " + this.getId() 
                    + " from Parttime"
                    + " to Fulltime");
            this.setCategorize("x");
            //s = s.concat("\n");
        return s;
    }
    
    public String setId_room() throws IOException{
        HR_Department test = new HR_Department();
        test.readFile();
        int k;
            String s = (super.getName() 
                    + " have id: " + this.getId() 
                    + " change id room from " + this.getId_room()
                    + " to ");
            
            do { 
                System.out.println("Enter id room:");
                k =cin.nextInt();
            } while(!test.checkMaP(String.valueOf(k)));
            this.setId_room(k);
            s = s.concat( Integer.toString(this.getId_room()) );
            //s = s.concat("\n");
        return s;
    }
    
    public String setId_room_id(int idroom) throws IOException{
            String s = (super.getName() 
                    + " have id: " + this.getId_room()
                    + " change id room from " + this.getId_room()
                    + " to ");
            this.setId_room(idroom);
            s = s.concat(String.valueOf(this.getId_room()));
        return s;
    }
    
    public String setSalary() throws IOException{
            String s = (super.getName() 
                    + " have id: " + this.getId() 
                    + " from " + this.getSalary()
                    + " to ");
            System.out.println("Enter new Saraly:");
            this.setSalary(cdou.nextDouble());
            s = s.concat( Double.toString(this.getSalary()) );
            //s = s.concat("\n");
        return s;
    }
    
    public String setPosition() throws IOException{
            String s = (super.getName() 
                    + " have id: " + this.getId() 
                    + " from " + this.getPosition()
                    + " to ");
            System.out.println("Enter new Position:");
            this.setPosition(gets.nextLine());
            s = s.concat(this.getPosition());
            //s = s.concat("\n");
        return s;
    }
    
    //truu tuong
    public abstract double calWages () throws IOException;

    
    //cac ham so sanh
    //so sanh ten
    public static int NameTangdan(Employee a, Employee b){
        return a.getName().compareTo(b.getName());
    }
    public static int NameGiamdan(Employee a, Employee b){
        return b.getName().compareTo(a.getName());
    }
    //so sanh id
    public static int IdTangdan(Employee a, Employee b){
        int x = Integer.parseInt(a.getId());
        int y = Integer.parseInt(b.getId());
        if ( x < y ) {
            return -1;
        } 
        else {
            if (x == y ) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int IdGiamdan(Employee a, Employee b){
        int x = Integer.parseInt(a.getId());
        int y = Integer.parseInt(b.getId());
        if ( x > y ) {
            return -1;
        } 
        else {
            if (x == y ) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    //so sanh tuoi
    public static int AgeTangdan(Employee a, Employee b){
        if (a.getAge() < b.getAge()) {
            return -1;
        } 
        else {
            if (a.getAge() == a.getAge()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int AgeGiamdan(Employee a, Employee b){
        if (a.getAge() > b.getAge()) {
                    return -1;
        } 
        else {
            if (a.getAge() == a.getAge()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    //so sanh phong
    public static int IdPhongTangdan(Employee a, Employee b){
        if (a.getId_room() < b.getId_room()) {
            return -1;
        } 
        else {
            if (a.getId_room() == a.getId_room()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int IdPhongGiamdan(Employee a, Employee b){
        if (a.getId_room() > b.getId_room()) {
                    return -1;
        } 
        else {
            if (a.getId_room() == a.getId_room()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    //so sanh tuoi
    public static int LuongTangdan(Employee a, Employee b){
        if (a.getSalary()< b.getSalary()) {
            return -1;
        } 
        else {
            if (a.getSalary() == a.getSalary()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    public static int LuongGiamdan(Employee a, Employee b){
        if (a.getSalary() > b.getSalary()) {
                    return -1;
        } 
        else {
            if (a.getSalary() == a.getSalary()) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    //sap xep theo loai
    public static int Full_Hafl(Employee a, Employee b){
        return b.getCategorize().compareTo(a.getCategorize());
    }
    public static int Hafl_Full(Employee a, Employee b){
        return a.getCategorize().compareTo(b.getCategorize());
    }
    //sap xep theo gioi tinh
    public static int Nam(Employee a, Employee b){
        return a.getGender().compareTo(b.getGender());
    }
    public static int Nu(Employee a, Employee b){
        return b.getGender().compareTo(a.getGender());
    }
}
