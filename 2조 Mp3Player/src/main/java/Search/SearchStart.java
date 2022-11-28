//package cse.state;
package Search;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SearchStart implements State {
    

    @Override
    public void StartsearchMusic(Searchtest search) {
        search.starts();
        search.ChangeState();
    }

    @Override
    public void StopsearchMusic(Searchtest search) {
        System.out.println("다시선택하세요");
    }

}
