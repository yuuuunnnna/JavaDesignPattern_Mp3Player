package MusicPackage;

public class showMusic implements Command{
    private showMyList listshow;
    
    public showMusic(showMyList listshow) {
        this.listshow = listshow;
    }
    public void execute() {
        listshow.showMusic();
    }
}
