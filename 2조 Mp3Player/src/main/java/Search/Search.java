/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cse.state;
package Search;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author 이유나
 */
public class Search {
    public State state;
    public int start;
    public int stop;
    
    
   public static void starts(){
       System.out.println("검색할 음악을 입력하세요: >>");
      }
    
   
  public static void StartsearchMusic() throws IOException {
       String str;
    boolean flag = false;
    String input;
    BufferedReader in = null;
  
    
    in = new BufferedReader( new InputStreamReader(System.in));
   
    str = in.readLine(); 
    
    in = new BufferedReader( new FileReader("DB\\Music\\music.txt"));
    String line;
    flag= false;
    while((line = in.readLine()) != null && flag == false){ 
     
     String[] music = line.split(",");
    
    
     if(music[0].trim().compareToIgnoreCase(str.trim()) == 0){ // 같으면 0 다르면 0이아닌 다른 숫자
         System.out.println("===================================================");
      System.out.println("곡명>" + music[0]);//단어출력,공백제거
      System.out.println("재생 시간>" + music[1]);
      System.out.println("아티스트>" + music[2]);
      System.out.println("곡 유형>" + music[3]);
      System.out.println("곡 장르>" + music[4]);
      System.out.println("발매일>" + music[5]);
      System.out.println("===================================================");
            flag= true;
      
     }

     
     }
    if(!flag){
     System.out.println("찾는 음악이 존재하지 않습니다.");
    }
    System.out.println();
  }

 public static void StopsearchMusic() {
     System.out.println("검색을 종료합니다.");
      
     
  }

  
 public static void ChangeState() throws IOException {
    
     boolean check = true;
     
     Scanner sc = new Scanner(System.in);
        while(check == true){
            System.out.println("1.음악검색 2.검색종료");
            System.out.print(">>");
             String num = sc.nextLine();
            switch(num){
                case "1" :  
                   starts();
                   StartsearchMusic();
                   check = false;
                   break;
                case "2" : 
                    StopsearchMusic();
                    check = false;
                    break;
                default: System.out.println("다시 선택하세요"); break;
            }
        }
}
 
 public static void message(String s){
     System.out.println(s);
 }
}
