package Qly_NhanSu;

import java.util.*;
import java.io.*;

public class HR_User implements HR_Interface{
    protected List<User> list_user;
    
    private String File_Users  ="./src/Qly_NhanSu/Account/acc.txt";
    private String Backup_File ="./src/Qly_NhanSu/Backup/acc.txt";
    
    Scanner gets = new Scanner(System.in);

    public HR_User(List<User> list_user) {
        this.list_user = list_user;
    }
    
    public HR_User() {
        list_user = new ArrayList<>();
    }
    
    public void add_Acc(String id,String position){
        System.out.println("\n=============Create a new Account=============");
        User temp = new User();
        temp.setId(id);
        temp.setPosition(position);
        do {
            System.out.println("enter usename: ");
            temp.setUser(gets.nextLine());
        } while( checkUser(temp.getUser()));
        System.out.println("enter password: ");
        temp.setPassword(gets.nextLine());
        list_user.add(temp);
    }
    
    public boolean check_existId(String id){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User e = it.next();
            if(e.getId().compareToIgnoreCase(id)==0){
                System.out.println("We already have that id, Pleaze try again");
                return true;
            }
        }
        return false;
    }
        
    public boolean checkUser(String user){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User u = it.next();
            if(u.getUser().compareToIgnoreCase(user)==0){
                System.out.println("We already have that usename, Pleaze try again");
                return true;
            }
        }
        return false;
    }
    
    public User nhapinfo(){
        User newUser = new User();
        while(true){
            System.out.println("Enter the usename ");
            newUser.setUser(gets.nextLine());
            if ( checkUser(newUser.getUser()) )
                System.out.println("");
            else
                break;
        }
        newUser.setInfo();
        return newUser;
    }
    
    public boolean add(User u){
        if( checkUser(u.getUser()) )
            return false;
        list_user.add(u);
        return true;
    }
    
    public boolean delete(String user){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User u = it.next();
            if(u.getUser().compareToIgnoreCase(user)==0){
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    public boolean changePass(String id){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User u = it.next();
            if(u.getId().compareToIgnoreCase(id)==0){
                System.out.printf("Enter new password:");
                u.setPassword(gets.nextLine());
                return true;
            }
        }
        return false;
    }
    
    public boolean changeUsername(String id){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User u = it.next();
            if(u.getId().compareToIgnoreCase(id)==0){
                System.out.printf("Enter new username:");
                String s;
                do{
                s = gets.nextLine();
                } while(checkUser(s));
                u.setUser(s);
                return true;
            }
        }
        return false;
    }
    
    //LOL
    public boolean forgetPass(String user){
        for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
            User u = it.next();
            if(u.getUser().compareToIgnoreCase(user)==0){
                System.out.printf("Enter new password:");
                u.setPassword(gets.nextLine());
                return true;
            }
        }
        return false;
    }
    
    public void deleteAll(){
        list_user.removeAll(list_user);
    }
    
    public void writeFile() throws IOException{   
        BufferedWriter xuat = new BufferedWriter(new FileWriter(File_Users));
        for ( User a : list_user ) 
            a.writeFile(xuat);
        xuat.close();
    }
    
    public void writeFile_Backup() throws IOException{   
        BufferedWriter xuat = new BufferedWriter(new FileWriter(Backup_File));
        for ( User a : list_user ) 
            a.writeFile(xuat);
        xuat.close();
    }
    
    public void readFile() throws IOException{    
        BufferedReader nhap = null;
        try {
            nhap = new BufferedReader(new FileReader(File_Users));
            String s = null;
            do {
                s = nhap.readLine();
                User u = new User();
                if ( u.readFile(s) )
                    list_user.add(u);
            } while ( s!=null);
            
            nhap.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading Account file");
        }
    }
    
    public void readFile_Backup() throws IOException{    
        BufferedReader nhap = null;
        try {
            nhap = new BufferedReader(new FileReader(Backup_File));
            String s = null;
            do {
                s = nhap.readLine();
                User u = new User();
                if ( u.readFile(s) )
                    list_user.add(u);
            } while ( s!=null);
            nhap.close();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Something wrong when reading Account file");
        }
    }
    
    public void display(){
        System.out.println(" __________________________________________");
        System.out.println("|  Id    |   Username     |    position    |");
        for (User a:list_user)
            System.out.printf("|   %-5s| %-13s  | %-14s |\n",a.getId(),a.getUser(), a.getPosition());
        System.out.println("|________|________________|________________|");
    }
    
    public User log () throws IOException{
        Menu_HOME();
        User temp = new User();
        int k=0;
        do {
            temp.setInfo();
            for (Iterator<User> it = list_user.iterator(); it.hasNext();) {
                User u = it.next();
                if(u.getUser().compareToIgnoreCase(temp.getUser())==0 && u.getPassword().compareToIgnoreCase(temp.getPassword())==0){
                   System.out.printf(
                            " _______________________________________________\n" +
                            "|                                               |\n" +
                            "|   ID: %-7s CHUCVU:  %-14s         |\n" +
                            "|_______________________________________________|\n",u.getId(),u.getPosition()
                    );
                    temp = u;
                }
            }   
            if (temp.getPosition()==null){
                System.out.println("=================PLeaze try again=================");
                k++;
                if (k==3){
                    String s;
                    System.out.println("I seem we lost database wanna backup file?\n    yes or no");
                    System.out.println("==================================================");
                    s = gets.nextLine();
                    s = s.toLowerCase();
                    if (s.equals("yes"))
                        readFile_Backup();
                    k=0;
                }
            }    
        }while(temp.getPosition()==null);
        return temp;
    }
    
    public void Menu_HOME(){
        System.out.println(
                " _______________________________________________ \n" +
                "|                                               |\n" +
                "|         WELCOME TO OUR APPLICATION            |\n" +
                "|_______________________________________________|\n" +
                "|                                               |\n" +
                "|                    Login                      |\n" +
                "|_______________________________________________|\n"
        );
    }
    
    public void Menu_END(){
        System.out.println(
                " _______________________________________________ \n" +
                "|                                               |\n" +
                "|      THANKS FOR USING OUR APPLICATION         |\n" +
                "|                                               |\n" +
                "                                                 \n" +
                "            • ˚ •˛•˚ * 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
                "            • ˚Happy★* 。 • ˚ ˚ ˛ ˚ ˛ •          \n" +
                "            •。★Holidays!★ 。* • ˚。             \n" +
                "            ° 。 ° ˛˚˛ *__Π____*。*˚             \n" +
                "            ˚ ˛ •˛•˚ */______/~＼。˚ ˚ ˛         \n" +
                "            ˚˛ •˛• ˚ ｜ 田田 ｜門｜ ˚              \n" +
                "                                                 \n" +
                "                                                 \n" +
                "|                                               |\n" +
                "|     MERRY CHRISTMAS AND HAPPY NEW YEAR        |\n" +
                "|_______________________________________________|");
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
