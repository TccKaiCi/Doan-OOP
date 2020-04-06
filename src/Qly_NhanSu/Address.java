package Qly_NhanSu;

import java.util.Scanner;


public class Address {
    private String ward;     //phuong
    private String district; //quan
    private String city;     //thanh pho
    
    Scanner scan=new Scanner(System.in);
    
    ///bo khoi tao
    public Address() {
    }

    public Address(String ward, String district, String city) {
        this.ward = ward;
        this.district = district;
        this.city = city;
    }

    //cac phuong thuc set-get
    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //sua doi toan bo thong tin dia chi
    public void setInfo(){
        System.out.println("Enter the ward ");
        this.setWard(scan.nextLine());
        System.out.println("Enter the district ");
        this.setDistrict(scan.nextLine());
        System.out.println("Enter the city ");
        this.setCity(scan.nextLine());
    }

    @Override
    public String toString() {
        return "Address{" + "ward=" + ward + ", district=" + district + ", city=" + city + '}';
    }
    
    
}
