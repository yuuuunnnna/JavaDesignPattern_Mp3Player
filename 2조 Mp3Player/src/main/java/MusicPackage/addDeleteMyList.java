package MusicPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class addDeleteMyList {
    static int check = 0;
    String id; // 사용자 아이디
    Boolean ok = true;
    public addDeleteMyList(String id){
        this.id = id;
    }
    public void addList() {
        System.out.println("추가할 리스트 이름 입력 : ");
        Scanner sc = new Scanner(System.in);
        String listName = sc.nextLine();
              
              
            ok = true;  
              
        try{
            File myFile = new File("DB\\playlist\\"+id +"\\information.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
        
            String line = null;
            
            while((line = reader.readLine()) != null && ok == true){
                check++;
                if(line.equals(listName)){ // 일치하는 음악 존재 여부
                    ok = false;                                       
                }
            }              
            }catch(Exception ex){
            ex.printStackTrace();
        }
        
        if(ok){
        try {
            OutputStream output = new FileOutputStream("DB\\playlist\\"+id +"\\"+listName+".txt");
            //listName으로 플레이리스트 이름 생성(영어만 가능)
	    String str ="@@@@@@@@@"+listName+" PLAYLIST@@@@@@@@@@.";
	    byte[] by=str.getBytes();
	    output.write(by);
            
            File file = new File("DB\\playlist\\"+id +"\\information.txt");
            FileWriter fw = new FileWriter(file,true);
            fw.write(listName + "\n");
            fw.flush();
            fw.close();
	} catch (Exception e) {
            e.getStackTrace();
	}
        System.out.println("리스트가 추가됨");
        
        }
        else{
            System.out.println("이미 존재하는 리스트 입니다.");
            addList();
        }
        
    }
    
    public void deleteList() {
        System.out.println("\n삭제할 리스트 이름 입력 : ");
        Scanner sc = new Scanner(System.in);
        String listName = sc.nextLine();          
        
        Boolean ok = true;
        try{
            File myFile = new File("DB\\playlist\\"+id +"\\information.txt"); 
            // 리스트 저장소의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
        
            String line = null;
            String[] array;
            check = 0;
            while((line = reader.readLine()) != null && ok == true){
               check++;
                if(line.equals(listName)){ // 일치하는 계정 존재
                    ok = false;                                       
                }
            }              
            }catch(Exception ex){
            ex.printStackTrace();
        }
        // txt 파일 목록 삭제후 위로 올리기
        String dummy = "";
                 try {
                        BufferedReader br = new BufferedReader(new FileReader("DB\\playlist\\"+id +"\\information.txt"));
                        String line;
                        for(int i=0; i<check-1; i++) {
                           line = br.readLine();
                           dummy += (line + "\r\n" );                                                                             
                        }
                        br.readLine();
                        while((line = br.readLine())!=null) {
                            dummy += (line + "\r\n" ); 
                        }
                        FileWriter fw = new FileWriter("DB\\playlist\\"+id +"\\information.txt");
                        fw.write(dummy);			
                        fw.close();
                        br.close();
                                        
                    } catch (Exception e) {			
                        e.printStackTrace();
                    }
                 
        File file = new  File("DB\\playlist\\"+id +"\\"+listName+".txt");
        
        if(file.exists()) {
            if(file.delete()){ 
                System.out.println("파일삭제 성공"); 
                System.out.println("리스트가 삭제됨");
            }else{ 
                System.out.println("파일삭제 실패"); 
            } 
        }else{ 
            System.out.println("파일이 존재하지 않습니다.");       
        }
        
    }

}
