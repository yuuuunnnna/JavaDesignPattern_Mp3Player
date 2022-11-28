package MusicPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class showMyList {
    String id;
    public showMyList(String id){
        this.id = id;
    }
    public void showList() {
        System.out.println("@@@현재 저장되어 있는 플레이리스트 출력@@@");
        BufferedReader bReader = null;
        
        try {            
            String s;
            File file = new File("DB\\playlist\\"+id +"\\information.txt"); 
            // 파일 경로 사용자에 의한 변수로 재설정 필요함
            bReader = new BufferedReader(new FileReader(file));
            
            while((s = bReader.readLine()) != null) {
                System.out.println(" - " + s);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bReader != null) bReader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void showMusic() {
        System.out.println("@@@음악 정보 출력@@@");
        System.out.println("열기 원하는 리스트 이름 입력 : ");
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine();
        BufferedReader bReader = null;
        
        try {            
            String s;
            File file = new File("DB\\playlist\\"+id + "\\"+list +".txt"); 
            // 파일 경로 사용자에 의한 변수로 재설정 필요함
            bReader = new BufferedReader(new FileReader(file));
            
            String music[] ;
            bReader.readLine();
            while((s = bReader.readLine()) != null) {
                music = s.split(",");
                System.out.println("곡명>" + music[0]+"  재생 시간>" + music[1]+"  아티스트>" + music[2]+"  곡 유형>" + music[3]+"  곡 장르>" + music[4]+"  발매일>" + music[5]);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bReader != null) bReader.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}