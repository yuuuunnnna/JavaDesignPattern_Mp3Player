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
public class Normalwork  extends PlaySystem {
    
     public Normalwork(PlayHandler playhandler){
        super(playhandler);
    }
    
    @Override
    public void playmethod() {
        System.out.println("일반 재생 시작!!>>>>");
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
