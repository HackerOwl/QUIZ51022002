/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022002;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
/**
 *
 * @author Lab20703
 */
public class IO51022002 {
    int l=0, tl=0;
    public void SimpanData(String nim, String nama, String ntugas, String nkuis, String nmid, String nfinal, String nakhir, String stotal){
        try{
            FileOutputStream fout=new FileOutputStream("QUIZ51022002.dat",false);
            DataOutputStream out=new DataOutputStream(fout);
            out.writeUTF(nim);
            out.writeUTF(nama);
            out.writeUTF(ntugas);
            out.writeUTF(nkuis);
            out.writeUTF(nmid);
            out.writeUTF(nfinal);
            out.writeUTF(nakhir);
            out.writeUTF(stotal);
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    public String ReadData(){
        String nim,nama,ntugas,nkuis,nmid,nfinal,nakhir,stotal;
        String temp="",data="";
        try{
            FileInputStream fin=new FileInputStream("QUIZ51022002.dat");
            DataInputStream in=new DataInputStream(fin);
          
            while (in.available()>0){
                nim=in.readUTF();
                nama=in.readUTF();
                ntugas=in.readUTF();
                nkuis=in.readUTF();
                nmid=in.readUTF();
                nfinal=in.readUTF();
                nakhir=in.readUTF();     //ambil Id sales
                stotal=in.readUTF();  //ambil Point sales
                if (stotal.equals("E")){
                    tl++;
                }else {
                    l++;
                }
                temp="NIM = "+nim+"\nNAMA = "+nama+"\n Tugas = "+ntugas+"\nKUIS = "+nkuis+"\nMID = "+nmid+"\nNILAI FINAL = "+nfinal+"\nNILAI AKHIR = "+nakhir+"\nNILAI HURUF = "+stotal+"\n ";  //bentuk string
                data+=temp; //masukkan setiap data ke string akhir
            }                              
            in.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(data);
    }
    public int getl(){
        return l;
    }
     public int gettl(){
        return tl;
    }
}