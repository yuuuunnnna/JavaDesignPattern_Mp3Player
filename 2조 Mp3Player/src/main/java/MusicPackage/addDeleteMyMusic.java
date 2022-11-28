package MusicPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class addDeleteMyMusic {
     int check = 0;
    private String id; // 사용자 id
        public addDeleteMyMusic(String id){
        this.id = id;
    }
    public void deleteMusic() {
        System.out.println("원하는 리스트 입력 : ");
        Scanner sclist = new Scanner(System.in);
        String list = sclist.nextLine();
        
        System.out.println("삭제할 음악 입력 : ");
        Scanner deleteSc = new Scanner(System.in);    
        String delMusic = deleteSc.nextLine();
        
        read(delMusic, list); 
        
        String dummy = "";
                 try {
                        BufferedReader br = new BufferedReader(new FileReader("DB\\playlist\\"+id +"\\"+list+".txt"));
                        String line;
                        for(int i=0; i<check-1; i++) {
                           line = br.readLine();
                           dummy += (line + "\r\n" );                                                                             
                        }
                        br.readLine();
                        while((line = br.readLine())!=null) {
                            dummy += (line + "\r\n" ); 
                        }
                        FileWriter fw = new FileWriter("DB\\playlist\\"+id +"\\"+list+".txt");
                        fw.write(dummy);			
                        fw.close();
                        br.close();
                                        
                    } catch (Exception e) {			
                        e.printStackTrace();
                    }
        System.out.println("음악 삭제 완료");
    }
    public void addMusic() {       
        System.out.println("원하는 리스트 입력 : ");
        Scanner sclist = new Scanner(System.in);
        String list = sclist.nextLine();
        File file = new File("DB\\playlist\\"+id +"\\"+list+".txt");
        FileWriter writer = null;
        System.out.println("추가할 음악 입력 : ");
        Scanner sc = new Scanner(System.in);
        String musicName = sc.nextLine();
        String info = addmusiclist(musicName,list);
        try {            
            writer = new FileWriter(file, true);
            writer.write("\n"+info);
            writer.flush();
            
        System.out.println("선택한 음악 추가됨.");    
        
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }    
    }
     void read(String str, String list) {
        Boolean ok = true;
        try{
            File myFile = new File("DB\\playlist\\"+id +"\\"+list+".txt"); // 사용자의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
        
            String line = null;
            String[] array;
            check = 0;
            while((line = reader.readLine()) != null && ok == true){
               check++;
                if(line.equals(str)){ // 일치하는 계정 존재
                    ok = false;                                       
                }
            }              
            }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        String addmusiclist(String music,String list) { // 기존에 있는 음악에서 추가
        Boolean ok = true;
        String information = null;
        try{
            File myFile = new File("DB\\Music\\music.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
        
            String line = null;
            String[] array;
            check = 0;
            while((line = reader.readLine()) != null && ok == true){
                check++;
               array = line.split(",");
                if(music.equals(array[0])){ // 일치하는 음악 존재 여부
                    ok = false;      
                    information = line; //음악 리스트에 있다면 그 음악 정보를 변수에 임시 저장
                }
            }              
            }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return information; // 음악 정보 추가
    }
}
