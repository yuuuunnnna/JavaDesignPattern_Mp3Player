
package buyticket;

public abstract class BuyTicket {
  protected BuyMusicBehavior buyMusicBehavior;
  protected BuyPeriodBehavior buyPeriodBehavior;

 
  
  public abstract void display() ;

  public void performMusicbuy() {
      buyMusicBehavior.musicbuy();
      
  }

  public void performPeriodbuy() {
      buyPeriodBehavior.periodbuy();
  }
  public abstract int getter();
  public abstract void select();

}
