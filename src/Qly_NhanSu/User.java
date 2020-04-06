package Qly_NhanSu;

import java.util.*;
import java.io.*;

public class User {
    
    private String id;
    private String user;
    private String password;
    private String position;

    Scanner gets = new Scanner(System.in);
    
    public User() {
    }

    public User(String id, String user, String password, String position) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public void display(){
        System.out.println("Id: "+this.id+" usename "+ this.user +" position:"+ this.position);
    }

    public void setInfo (){
        System.out.printf("enter usename: ");
        this.setUser(gets.nextLine());
        System.out.printf("enter password: ");
        this.setPassword(gets.nextLine());
    }
    
    public void writeFile(BufferedWriter out) throws IOException{
        try {
            out.write(this.getId() + "|");
            out.write(this.getPosition()+ "|");
            out.write(this.getUser() + "|");
            out.write(this.getPassword() + "|");
            out.newLine();
        } catch (Exception e) {
            System.out.println("Error in writing ");
        }
    }
    
    public boolean readFile(String s){ 
        if (s!=null){
            String[] inp = s.split("\\|");
            this.setId(inp[0]);
            this.setPosition(inp[1]);
            this.setUser(inp[2]);
            this.setPassword(inp[3]);
            return true;
        }
        return false;
    }
}
