//package cse.state;
//package cse.state;
package Search;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Searchstop implements State {

    private Object s;

    @Override
    public void StartsearchMusic(Searchtest search) {
        search.ChangeState();
    }

    @Override
    public void StopsearchMusic(Searchtest search) {
       System.out.println("다시 선택하세요");
    }
    
 public void message(Searchtest search){
     search.message("검색완료");
}
}
        