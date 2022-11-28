package MusicPackage;

public class deleteMusicOnList implements Command{
    private addDeleteMyMusic musiconlist;
    
    public deleteMusicOnList(addDeleteMyMusic musiconlist){
        this.musiconlist = musiconlist;
    }
    
    public void execute() {
        musiconlist.deleteMusic();
    }
}
