package information;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class BuilderPattern {
  private String name;
  private String time;
  private String artist;
  private String type;
  private String genre;
  private String date;
 
  public void  constructMusic() {
     MusicinformationBuilder musicinformationbuilder = new MusicinformationBuilder();
     Scanner scan = new Scanner(System.in); 
     String input;
 
     while(true){
         
     System.out.println("음악제목을 입력하세요.");
     name = scan.nextLine();
   
     System.out.println("재생시간을 입력하세요.");
     time = scan.nextLine();
     
     System.out.println("아티스트를 입력하세요.");
     artist = scan.nextLine();
     
     System.out.println("곡 유형을 입력하세요.");
     type = scan.nextLine();
     
     System.out.println("곡 장르를 입력하세요.");
     genre = scan.nextLine();
     
     System.out.println("발매일을 입력하세요.");
     date = scan.nextLine();
    
     System.out.println("위와 같이 새로운 음악을 추가합니까?(y/n)");
     input = scan.nextLine();
     if(input.equals("y")){
         Musicinformation result = musicinformationbuilder
             .setName(name)
             .setTime(time)
             .setArtist(artist)
             .setType(type)
             .setGenre(genre)
             .setDate(date)
             .build();
         try( //여기서 객체 생성 시 try 종료 후 자동으로 close처리, true 기존 파일에 이어서
                 FileWriter fw = new FileWriter("DB\\Music\\music.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 )
         {
             bw.write("\r\n"+name+",");
             bw.write(time+",");
             bw.write(artist+",");
             bw.write(type+",");
             bw.write(genre+",");
             bw.write(date);
             bw.flush();
         }catch(IOException e){
             System.out.println(e);
         }
 
         System.out.println("======================\n");
         System.out.println(result.getMusicInfo());
         System.out.println("======================");
         break;
         
        }else if(input.equals("n")){
            System.out.println("======================");
            System.out.println("다시 입력해주세요.");
            System.out.println("======================");
        }
     }
  }

  
}
