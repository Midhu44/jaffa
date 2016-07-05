/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadWriteFile {

    String id = null;
    String name = null;
    String dept = null;
    String doj = null;
    String adrss = null;

    public void WriteFile(String Id, String Name, String Dept, String Doj, String Adrss) throws IOException {
        File f = new File("TraineeDetails.dat");
        if (!f.exists()) {
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("TraineeDetails.dat", true));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Id : ");
            Id = br.readLine();
            System.out.print("Enter name : ");
            Name = br.readLine();
            System.out.print("Enter dept : ");
            Dept = br.readLine();
            System.out.print("Enter doj : ");
            Doj = br.readLine();
            System.out.print("Enter adrss : ");
            Adrss = br.readLine();
            bw.write(Id + "::" + Name + "::" + Dept + "::" + Doj + "::" + Adrss + ":END:");
            bw.flush();
            bw.newLine();
            bw.close();

        }
    }

    public static void main(String[] args) throws IOException {
        ReadWriteFile rwf = new ReadWriteFile();
        String TID = null;
        String TADRSS = null;
        String TDOJ = null;
        String TNAME = null;
        String TDEPT = null;
        rwf.ReadFile(TID, TNAME, TDEPT, TDOJ, TADRSS);

    }

    public void ReadFile(String Id1, String Name1, String Dept1, String Doj1, String Adrss1) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/MSCVP/Trainee.dat"));
        String s;
        StringTokenizer st = null;
        while ((s = br.readLine()) != null) // Create string tokenizer
        {
            st = new StringTokenizer(s, "::");
            System.out.println("----------------------------------------------");
            System.out.println("| Trainee Id: " + st.nextToken() + "|");
            System.out.println("| Trainee Name: " + st.nextToken() + "|");
            System.out.println("| Trainee Department:" + st.nextToken() + "|");
            System.out.println("| Date of Joining: " + st.nextToken() + "|");
            System.out.println("| Trainee Address: " + st.nextToken() + "|\n");
            System.out.println("----------------------------------------------");
        }

        // Close file reader
        br.close();
    }
}
