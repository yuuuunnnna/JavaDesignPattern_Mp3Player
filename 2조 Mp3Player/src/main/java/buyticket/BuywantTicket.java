package buyticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BuywantTicket {
      private  String a;
      private  String input;
      private  int useMusic ; // 음악기관권/ 음악구매권 값 받아옴
      private  String id ;  // 연결되면 값 지정된건 지운다.
     private  int line; // 연결되면 지워야함
     private  boolean isPeriod = false; // 기간권인지 체크
     private  int gap = 0;
     
     public BuywantTicket(String id){
         this.id = id;
      Select();   
     }
     public BuywantTicket(){
         
     }
  
  public  void Select(){
      Scanner scan = new Scanner(System.in);
      
            while(true){
       System.out.println("===================================================");
      System.out.println("1. 음악기간권 / 2. 음악구매권 \n구매하실 티켓을 선택하여 주세요.(번호 선택/종료: q) ");
    System.out.println("===================================================");                
          a= scan.next();
          if (a.equals("q")){
              System.out.println("종료합니다.");
              break;
          }
          else if(a.equals("1")){
              BuyTicket buyperiod = new BuyPeriod();
              buyperiod.display();
              buyperiod.performPeriodbuy();
              useMusic = buyperiod.getter();
              isPeriod = true; 
              finish();
              break;
          }
          else if(a.equals("2")){
              BuyTicket buymusic = new BuyMusic();
              buymusic.display();
              buymusic.performMusicbuy();
              useMusic = buymusic.getter();
              isPeriod = false;
              finish();
              break;
          }
          else {
              System.out.println("잘못된 번호를 입력하셨습니다.");
          }
              
      }
  }
  public  void finish(){ // 구매 종료
      Scanner scan = new Scanner(System.in);
      
          while(true){
              System.out.println("===================================================");
              System.out.println("구매하시겠습니까? (y/n)");
              input = scan.nextLine();
              
              if(input.equals("y")){
                  modifyFile(id,useMusic);
                  if(isPeriod == true){
                      System.out.println(id + "님 "+gap+"일 구매완료");
                  }
                  else{
                      System.out.println(id + "님 "+gap+"회 구매완료");
                  }
                  
                  break;
              }else if(input.equals("n")){
                  System.out.println("이용권 구매 종료합니다.");
                  break;
              }else {
                  System.out.println("다시 입력해주세요");
              }
  }
  }
     
  public  void modifyFile(String id,int use){ // 사용자의 이용권 변경
          
         
         int check = readfile(id);
         String dummy = "";
         String data[] ;
         int gap;
         		try {
		BufferedReader br = new BufferedReader(new FileReader("DB\\id_passwd.txt"));
			String line;
			for(int i=0; i<check-1; i++) {
			    line = br.readLine();
			    dummy += (line + "\r\n" ); 
                                                                            
			}
			data = br.readLine().split("/");
                                                                            if(isPeriod == true){ // 사용자의 기간권 값 추가
                                                                                gap = changePeriod();
                                                                                int period = Integer.parseInt(data[4]);
                                                                                data[4] = Integer.toString(period+gap);
                                                                                String hap = data[0]+"/"+data[1]+"/"+data[2]+"/"+data[3]+"/"+data[4]+"\r\n";
                                                                                dummy += hap;
                                                                            }
                                                                            else{ // 음악권
                                                                                gap = changeMusic();
                                                                                  int times = Integer.parseInt(data[3]);
                                                                                  if (gap == 0){
                                                                                      times = 0;
                                                                                      gap = use;
                                                                                  }
                                                                                  data[3] = Integer.toString(times+gap);
                                                                                String hap = data[0]+"/"+data[1]+"/"+data[2]+"/"+data[3]+"/"+data[4]+"\r\n";
                                                                                dummy += hap;
                                                                            }
                                                                            
			while((line = br.readLine())!=null) {
				dummy += (line + "\r\n" ); 
			}
			FileWriter fw = new FileWriter("DB\\id_passwd.txt");
			fw.write(dummy);			
			fw.close();
			br.close();
                                           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
           
  public   int readfile(String id){ // id_passwd.txt 파일의 일치하는 id의 라인 수 체크
        String str = id;
        int check = 0;
        boolean ok = true;
        try{
            File myFile = new File("DB\\id_passwd.txt"); // 사용자의 정보를 읽는다.
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = null;
            String[] array;
            
            while((line = reader.readLine()) != null && ok == true ){
               // System.out.println("line : " +line);
               array = line.split("/"); 
               String idp = array[0];
                
               check++;
                if(idp.equals(id)){ // 일치하는 계정 존재
                    
                    ok = false;

                }
            }
              
            }catch(Exception ex){
            ex.printStackTrace();
        }
               
        return check;
    
}
           public  int changePeriod(){ // 기간이용권 변경 
               
               if(useMusic ==1){
                   gap = 1;
               }
               else if(useMusic ==2){
                   gap = 7;
               }
               else if(useMusic == 3){
                   gap = 31;
               }
               else if(useMusic == 4){
                   gap = 365;
               }
               return gap;
           }
           public  int changeMusic(){ // 음악 횟수구매권 변경
               
                if(useMusic ==1){
                   gap = 1;
               }
               else if(useMusic ==2){
                   gap = 3;
               }
               else if(useMusic == 3){
                   gap = 10;
               }
               
               
             return gap;
           }
}
