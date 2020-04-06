
package Qly_NhanSu;

import java.io.IOException;

public interface HR_Interface {
    public void writeFile()throws IOException;
    public void readFile()throws IOException;
    public void writeFile_Backup() throws IOException;
    public void readFile_Backup() throws IOException;
    public void display();
    public void sort();
}
