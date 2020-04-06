package Qly_NhanSu;

import java.util.*;
import java.io.*;

public class Department {
    
    private String id_room;
    private String name_room;
    private String id_bossroom;
    
    Scanner scan = new Scanner(System.in);
    Scanner cin  = new Scanner(System.in);

    public Department(){
    }

    public Department(String id_room, String name_room, String id_bossroom) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.id_bossroom = id_bossroom;
    }
        

    public String getId_room() {
        return id_room;
    }

    public void setId_room(String id_room) {
        this.id_room = id_room;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    } 

    public String getid_bossroom() {
        return id_bossroom;
    }

    public void setid_bossroom(String id_bossroom) {
        this.id_bossroom = id_bossroom;
    }
    
    public static int TenTangdan(Department a, Department b){
        return a.getName_room().compareTo(b.getName_room());
    }
    
    public static int TenGiamdan(Department a, Department b){
        return b.getName_room().compareTo(a.getName_room());
    }
    
    public static int IDTangdan(Department a, Department b){
        return a.getId_room().compareTo(b.getId_room());
    }
    public static int IDGiamdan(Department a, Department b){
        return b.getId_room().compareTo(a.getId_room());
    }
    
    public static int IDBOSSTangdan(Department a, Department b){
        return a.getid_bossroom().compareTo(b.getid_bossroom());
    }
    public static int IDBOSSGiamdan(Department a, Department b){
        return b.getid_bossroom().compareTo(a.getid_bossroom());
    }
    
    public void setInfo(){
        System.out.println("nhap ma phong: ");
        this.setId_room(scan.nextLine());
        System.out.println("nhap ten phong: ");
        this.setName_room(scan.nextLine());
        System.out.println("nhap id truong phong: ");
        this.setid_bossroom(scan.nextLine());
    }
    
    public void writeFile(BufferedWriter out) throws IOException{
        try{
            out.write(this.getId_room()+ "|");
            out.write(this.getName_room() + "|");
            out.write(this.getid_bossroom() + "|");
            out.newLine();
        }
        catch(Exception e){
            System.out.println("ERROR !!");
        }
    }
    
    public  boolean readFile(String s){
        if(s!=null){
            String[] inp= s.split("\\|");
            this.setId_room(inp [0]);
            this.setName_room(inp [1]);
            this.setid_bossroom(inp [2]);
            return true;
        }
        return false;
    }

    public void display(){
        System.out.println("__________________________________________");           
        System.out.println("|  Id room |   Name room   | Id bossroom |");
        System.out.println("|__________|_______________|_____________|");
        System.out.printf("| %-9s| %-14s|  %-11s| \n"
                    , this.getId_room(), this.getName_room()
                    , this.getid_bossroom()
        );
        System.out.println("|__________|_______________|_____________|");
        System.out.println("");
    }
}
