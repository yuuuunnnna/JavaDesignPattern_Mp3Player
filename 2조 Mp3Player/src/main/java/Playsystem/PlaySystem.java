/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaySystem;

/**
 *
 * @author 이유나
 */
public abstract class PlaySystem {
      private PlayHandler playhandler;
      
  public PlaySystem(PlayHandler playhandler) {
      this.playhandler = playhandler;
  }
  
  public void stop() {
      playhandler.stop();
  }

  public void play(){
      playhandler.play();
  }
  
  public void playmethod(){
      play();
      stop();
  }
  public abstract void start();
    //
}


/*public abstract class PlaySystem {
      private PlayHandler playhandler;
      
  public PlaySystem(PlayHandler playhandler) {
      this.playhandler = playhandler;
  }
  
  public void stop() {
      playhandler.stop();
  }

  public void play(){
      playhandler.play();
  }
  
  public abstract void start();
    //
}*/