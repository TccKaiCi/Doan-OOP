package Qly_NhanSu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HR_Department implements HR_Interface{
    private List<Department> list_Depar;
    
    private String File_Depar ="./src/Qly_NhanSu/Department/Depar.txt";
    private String Backup_File_Depar ="./src/Qly_NhanSu/Backup/Depar.txt";
    
    Scanner cin  = new Scanner(System.in);
    Scanner gets = new Scanner(System.in);

    public HR_Department(ArrayList<Department> list_Depar) {
        this.list_Depar = list_Depar;
    }
    
    public HR_Department() {
        list_Depar =new ArrayList<>();
    }
   
    //kiem tra su ton tai cua phong ban
    public boolean checkMaP(String id){
        for (Iterator<Department> it = list_Depar.iterator(); it.hasNext();) {
            Department e = it.next();
            if(e.getId_room().compareToIgnoreCase(id)==0){
                return true;
            }
        }
        return false;
    }
    
    //them phong ban
    public boolean addPB(Department e){
        if( checkMaP(e.getId_room()) )
            return false;
        list_Depar.add(e);
        return true;
    }   
    
    //xoa phong ban theo mapb
    public boolean deletePB(String idroom){
        for (Iterator<Department> it = list_Depar.iterator(); it.hasNext();) {
            Department pb = it.next();
            if (pb.getId_room().compareToIgnoreCase(idroom)==0){
                it.remove();
                return true;}
        }
        return false;
    }
    
    //xoa tat ca nhan vien
    public void deleteAll(){
        list_Depar.removeAll(list_Depar);
    }
    
    //sua thong tin phong toan ven
    public boolean sua(String idroom) {
        for (Iterator<Department> it = list_Depar.iterator(); it.hasNext();) {
            Department pb=it.next();
            if(pb.getId_room().compareToIgnoreCase(idroom)==0){
                pb.setInfo();
                return true;
            }
        }
        return false;
    }

    //tim kiem phong theo dia chi phong
    public boolean searchID(String idroom){
        for(Iterator<Department> it = list_Depar.iterator(); it.hasNext();){
            Department pb= it.next();
            if(pb.getId_room().compareTo(idroom)==0){
                pb.display();
                return true;
            }
        }
        return false;
    }
    
    public void display(){
        System.out.println("__________________________________________");           
        System.out.println("|  Id room |   Name room   | Id bossroom |");
        System.out.println("|__________|_______________|_____________|");
        for(Iterator<Department>  it = list_Depar.iterator(); it.hasNext();){
            Department pb=it.next();
            
            System.out.printf("| %-9s| %-14s|  %-11s| \n"
                    , pb.getId_room(), pb.getName_room()
                    , pb.getid_bossroom()
            );
        }
        System.out.println("|__________|_______________|_____________|");
        System.out.println("");
    }
    
    public void readFile() throws IOException{    
        BufferedReader nhap = null;
        try {
            nhap = new BufferedReader(new FileReader(File_Depar));
            String s = null;
            do {
                s = nhap.readLine();
                Department p = new Department();
                if ( p.readFile(s) )
                    list_Depar.add(p);
            } while ( s!=null);
            
            nhap.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading read file");
        }
    }

    public void writeFile() throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(File_Depar));
        for(Department pb : list_Depar){
            pb.writeFile(out);
        }
        out.close();       
    }
    
    public void readFile_Backup() throws IOException{    
        BufferedReader nhap = null;
        try {
            nhap = new BufferedReader(new FileReader(Backup_File_Depar));
            String s = null;
            do {
                s = nhap.readLine();
                Department p = new Department();
                if ( p.readFile(s) )
                    list_Depar.add(p);
            } while ( s!=null);
            
            nhap.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading read file");
        }
    }

    public void writeFile_Backup() throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(Backup_File_Depar));
        for(Department pb : list_Depar){
            pb.writeFile(out);
        }
        out.close();       
    }
    
    public void setId(String id,String ID){
        
        for (Department a:list_Depar){
            if (a.getId_room().compareTo(id)==0){
                a.setId_room(ID);
                a.display();
            }
        }
    }
    
    public void setName(String id,String ID){
        
        for (Department a:list_Depar){
            if (a.getId_room().compareTo(id)==0){
                a.setName_room(ID);
                a.display();
            }
        }
    }
    
    public boolean findDepartby_Id(String id){
        for ( Department a :list_Depar){
            if ( a.getId_room().equals(id) ){
                a.display();
                return true;
            }
        }
        return false;
    }
    
    public void add() throws IOException{
        Department p = new Department();
        do{
            System.out.println("nhap ma phong: ");
            p.setId_room(gets.nextLine());
        }while ( checkMaP(p.getId_room()) );
        System.out.println("nhap ten phong: ");
        p.setName_room(gets.nextLine());
        System.out.println("nhap id truong phong: ");
        p.setid_bossroom(gets.nextLine());
        list_Depar.add(p);
                
    }
    
    public void sortbyName(int k){
        if(k==0){
            Collections.sort(list_Depar, Department::TenTangdan);
        }
        else{
            Collections.sort(list_Depar, Department::TenGiamdan);
        } 
    }
    public void sortbyId(int k){
        if(k==0){
            Collections.sort(list_Depar, Department::IDTangdan);
        }
        else{
            Collections.sort(list_Depar, Department::IDGiamdan);
        }
    }

    public void sortbyIdBoss(int k){
        if(k==0){
            Collections.sort(list_Depar, Department::IDBOSSTangdan);
        }
        else{
            Collections.sort(list_Depar, Department::IDBOSSGiamdan);
        }
    }
        
    @Override
    public void sort() {
        System.out.println("Which sort?     \n"
                + "1.Sort by Name           \n"
                + "2.Sort by Id             \n"
                + "3.Sort by Id  boss           \n"
        );
        int k = cin.nextInt();
        switch( k ){
            case 1:
                //sap xep theo ten
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyName(k-1);
                break;
            case 2:
                //sap xep theo id
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyId(k-1);
                break;
            case 3:
                //sap xep theo id
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyIdBoss(k-1);
                break;        
        }
        display();
    }
}
