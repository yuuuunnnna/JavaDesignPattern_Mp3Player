package buyticket;

import java.util.Scanner;

public class BuyMusic extends BuyTicket {
    
    private int choice; // 곡 개수
  public void display() {
      System.out.println("===================================================");
      System.out.println("음악 구매권 구매입니다.");
  }

  public BuyMusic() {

      select();
  }
  public void select(){
        Scanner scan = new Scanner(System.in);
      
      
      while(true){
          System.out.println("===================================================");
          System.out.println("구매하실 음악구매권을 선택하여주세요.(번호 선택) \n1. 곡 한개 구매 "
                  + "\n2. 곡 세개 구매 \n3. 곡 열개 구매");
          
          choice =scan.nextInt();
          
          if(choice == 1){
              buyMusicBehavior = new BuyOne();
              
              break;
          }else if(choice ==2){
               buyMusicBehavior = new BuyThree();
              
               break;
          }else if(choice ==3){
               buyMusicBehavior = new BuyTen();
              
               break;
          }else{
              System.out.println("잘못 입력하셨습니다.");
          }
          
      }
  }
  public  int getter(){
      return choice;
  }

}
