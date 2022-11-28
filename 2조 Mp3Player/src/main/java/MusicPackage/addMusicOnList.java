package MusicPackage;

public class addMusicOnList implements Command{
    private addDeleteMyMusic musiconlist;
    
    public addMusicOnList(addDeleteMyMusic musiconlist) {
        this.musiconlist = musiconlist;
    }
    
    public void execute() {       
        musiconlist.addMusic();
    }
}
