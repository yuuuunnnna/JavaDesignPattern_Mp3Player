
package buyticket;

import java.util.Scanner;

public class BuyPeriod extends BuyTicket {
    private int choice; // 이용권 기간
  public void display() {
      System.out.println("===================================================");
      System.out.println("음악 기간권 구매입니다.");
  }

  public BuyPeriod() {
      select();

  }
  public void select(){
      Scanner scan = new Scanner(System.in);
            while(true){
                System.out.println("===================================================");
          System.out.println("구매하실 음악 기간권을 선택하여주세요.(번호 선택) \n1. 하루 이용권 구매 "
                  + "\n2. 일주일 이용권 구매 \n3. 한달 이용권 구매 \n4. 일년 이용권 구매");
          choice = scan.nextInt();
          
          if(choice == 1){
              buyPeriodBehavior = new ADay();
              
              break;
          }else if(choice ==2){
              buyPeriodBehavior = new AWeek();
              
              break;
          }else if(choice ==3){
              buyPeriodBehavior = new AMonth();
              
              break;
          }else if(choice == 4){
               buyPeriodBehavior = new AYear();
             
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
