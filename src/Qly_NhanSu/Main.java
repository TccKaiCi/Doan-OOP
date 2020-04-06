package Qly_NhanSu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {  
        HR_User a = new HR_User();
        a.readFile();
        User b = new User();
        b = a.log();
        a.deleteAll();
        Menu.Main(b.getId(),b.getPosition());
        a.Menu_END();

        //sap xep bang 2 thuoc tinh thi ta phai lam sao
    }
}
