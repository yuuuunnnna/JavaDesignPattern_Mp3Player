/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *
 * @author dbswl
 */
public class Login {
       static String passwd;
        static String id;
        static boolean c;
        public static int linenum = 0; // 계정 라인 수
       public static String Period;
       public static String Music;
        public Login() throws IOException{
                    System.out.println("===================================================");
        System.out.println("        안녕하세요! 컴소뮤직플레이어입니다.         ");
        System.out.println("로그인을 원하시면 아이디와 비밀번호를 입력해주세요.");
        System.out.println("===================================================");
        start();
        }
    
    static void start() throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print(" 아이디  : ");
        id = in.readLine();
        
        System.out.print("비밀번호 : ");
        passwd = in.readLine();
        
        System.out.println("===================================================");
        
        c = readfile(id,passwd); // 등록 확인
        
        if (c == true){
            Check fail = new Check(new CheckFail());
            fail.get(id);
            start();
        }
        else{
            lastcheck(id);
        }   
    }
    static boolean readfile(String id, String passwd){ // 등록이 되어있는지 확인
        String str = id+"/"+passwd;
        Boolean ok = true;
        String arr[];
        try{
            File myFile = new File("DB\\id_passwd.txt"); // 사용자의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            if(id.length() == 0 || passwd.length() == 0 ){ // 만약 입력하지않았다면 경고문과 로그인 취소    
                return ok;
       }            
            String line = null;
            
            while((line = reader.readLine()) != null && ok == true){
               arr = line.split("/");
               String s = arr[0] + "/" + arr[1];
               
               linenum++;
                if(s.equals(str)){
                    ok = false;
                     Period= arr[4];
                    Music = arr[3];
                   // System.out.println("str : " + str);
                }
            }  
            }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ok;
    }
    
    static void lastcheck(String id){ // 관리자 또는 사용자인지 확인
        switch(id.charAt(0)){
            case 'a':
                Check ad = new Check(new CheckEmployee());
                ad.get(id);
                break;
            case 'u':
                Check us = new Check(new CheckUser());
                us.get(id);
                break;
            default:
                System.out.println("로그인에 실패하였습니다.");
        }
    }
    public static String getId(){
        return id;
    }
    public static boolean getisAdmin(){
        if (id.charAt(0)== 'a'){
            return true;
        }
        else{
            return false;
        }
        
    }
        public static String getMusic(){
            readfile(id,passwd);
            return Music;
        
    }
        public static String getPeriod(){
            readfile(id,passwd);
            return Period;
        }
  
    }

