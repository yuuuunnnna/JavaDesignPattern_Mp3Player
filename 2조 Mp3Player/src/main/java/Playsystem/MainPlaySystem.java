/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cse.playsystem;
package PlaySystem;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import buyticket.*;
/**
 *
 * @author 이유나
 */
public class MainPlaySystem {
       ArrayList<String> music = new ArrayList<>();
       ArrayList<Integer> randnum = new ArrayList<>();
      BuywantTicket buywantticket = new BuywantTicket();
    private  Object FileIO;
    String id; // 사용자 id
    String list; // 원하는 플레이 리스트
    
    public MainPlaySystem(String id,String music) throws IOException{
        this.id = id;
        Scanner sc = new Scanner(System.in);
  
             PlaySystem Normalwork = new Normalwork(new Normalplay());//일반재생 
             PlaySystem Randomwork = new Randomwork(new Randomplay()); //셔플재생
           int realticket = Integer.parseInt(music);
             boolean check = true;
             int ticket = playlist();
             if (ticket <realticket && realticket != 0){
                 
             }
             else{
                 check = false;
             }
            while(check == true){
             
             
             
            System.out.println("1.일반재생 2.셔플재생");
            System.out.print(">>");
             int num = sc.nextInt();
            switch(num){
                case 1 :  
                    Normalwork.playmethod();
                    Normalwork.play();
                    normstart();
                    System.out.println("===============================");
                    System.out.println(ticket+"회 감소하였습니다.");
                    ticket = realticket - ticket;
                     buywantticket.modifyFile(id,ticket);
                    check = false;
                    Normalwork.stop(); break;
                    
                case 2 : 
                     Randomwork.playmethod();
                     Randomwork.play();
                     rand();
                     System.out.println("===============================");
                     System.out.println(ticket+"회 감소하였습니다.");
                     ticket = realticket - ticket;
                     buywantticket.modifyFile(id,ticket);
                     check = false;
                     Randomwork.stop(); break;
                default: System.out.println("다시 선택하세요"); break;
            }
            }
    }
    
   void normstart() throws IOException{
       
       
      File file = new File("DB\\playlist\\"+id + "\\"+list +".txt"); 
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = null;
            try{
                String music[];
                bufReader.readLine();
            while((line = bufReader.readLine()) != null){
                music = line.split(",");
                    System.out.println("곡명>" + music[0]+"  재생 시간>" + music[1]+"  아티스트>" + music[2]+"  곡 유형>" + music[3]+"  곡 장르>" + music[4]+"  발매일>" + music[5]);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();    
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
       }
    
      public void rand() {
           int gap = 0;
            try{
                File file = new File("DB\\playlist\\"+id + "\\"+list +".txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = null;
            bufReader.readLine();
            while((line = bufReader.readLine()) != null){
                music.add(line);
                gap ++;
            }      
            bufReader.close();    
            }catch(Exception ex){
                ex.printStackTrace();
            }
            inputrand(gap);
            
            String arr[];
           for(int r : randnum){
               arr = (music.get(r)).split(",");
                    System.out.println("곡명>" + arr[0]+"  재생 시간>" + arr[1]+"  아티스트>" + arr[2]+"  곡 유형>" + arr[3]+"  곡 장르>" + arr[4]+"  발매일>" + arr[5]);
           }  
      }
      
       void inputrand(int gap){
          boolean check = true;
            while(check == true){
            int rand = (int)(Math.random()*gap);
                if(randnum.size() != gap ){
                    
            if(randnum.contains(rand)){
                inputrand(gap);
            }
            else{
                randnum.add(rand);
            }
                }
                else{
                    check = false;
                }
            }
      }
      public int playlist(){
          
          System.out.println("원하시는 플레이리스트를 입력해주세요");
          try{
                File file = new File("DB\\playlist\\"+id + "\\information.txt"); 
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = null;
            
            while((line = bufReader.readLine()) != null){
                    System.out.println(line);
            }      
            bufReader.close();    
            }catch(Exception ex){
                ex.printStackTrace();
            }
          
          
        System.out.print(">>");          
        Scanner sc = new Scanner(System.in);
        
        list = sc.nextLine();
        int count = 0;
                  try{
                File file = new File("DB\\playlist\\"+id + "\\"+list+".txt"); 
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = null;
            
            bufReader.readLine();
            while((line = bufReader.readLine()) != null){
                    count++;
            }      
            bufReader.close();    
            }catch(Exception ex){
                ex.printStackTrace();
            }
          return    count; 
      }
}

        




        
       
        
       
     
