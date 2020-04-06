package Qly_NhanSu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.*;

public class Saraly {
    private int[] heso;
    private String[] position;
    private int n;

    private String File_Saraly = "./src/Qly_NhanSu/Saraly/saraly.txt";
    
    Scanner cin  = new Scanner(System.in);
    Scanner gets = new Scanner(System.in);
    
    public Saraly() {
        n=6;
        heso = new int[n];
        position = new String[n];
    }

    public Saraly(int[] heso, String[] position) {
        this.heso = heso;
        this.position = position;
    }
    
    public boolean setInfor(){
        System.out.printf("Enter position: ");
        String s = gets.nextLine();
        for (int i=0 ; i<n ; i++){
            if (position[i].compareToIgnoreCase(s)==0){
                System.out.printf("Enter new heso: ");
                heso[i] = cin.nextInt();
                return true;
            }
        }
        System.out.println("Sorry we dont have that postition");
        return false;
    }
    
    public void writeFile() throws IOException {
        BufferedWriter inp = new BufferedWriter(new FileWriter(File_Saraly) );
        try {
            for (int i=0 ; i<n ; i++){
                    inp.write(heso[i]+"|"+position[i]+"|");
                    inp.newLine();
            }
        } catch(Exception e){
            System.out.println("Oopss");
       }
        inp.close();
    }
    
    public void readFile() throws IOException {
        BufferedReader out = new BufferedReader(new FileReader(File_Saraly) );
        int i=0;
        try{
            String s = null;
            do {
                //doc tung dong
                s = out.readLine();
                String[] inp = s.split("\\|");
                heso[i]= Integer.parseInt(inp[0]);
                position[i]= inp[1];
                i++;
            } while ( s!=null);
            out.close();
        } catch (Exception e) {
        }
    }
    
    public void display(){
        System.out.println("====================================================");
        for (int i=0 ; i<n ; i++){
            System.out.printf("He so:%-3d    Chuc vu:%-10s\n",heso[i],position[i]);
        }
        System.out.println("====================================================");
    }
    
    public int calWages(String position) throws IOException{
        readFile();
        for (int i=0 ; i<n ; i++){
            if (this.position[i].compareToIgnoreCase(position)==0)
                return heso[i];
        }
        return 0;
    }
}
