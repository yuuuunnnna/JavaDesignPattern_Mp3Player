package information;

public class MusicinformationBuilder{
  private String name;
  private String time;
  private String artist;
  private String type;
  private String genre;
  private String date;

  public  MusicinformationBuilder  setName(String name) {
      this.name = name;
      return this;
  }

  public MusicinformationBuilder setTime(String time) {
      this.time = time;
      return this;
  }

  public MusicinformationBuilder  setArtist(String artist) {
      this.artist=artist;
      return this;
  }

  public MusicinformationBuilder  setType(String type) {
      this.type=type;
      return this;
  }

  public MusicinformationBuilder setGenre(String genre) {
      this.genre=genre;
      return this;
  }

  public MusicinformationBuilder setDate(String date) {
      this.date = date;
      return this;
  }

  public Musicinformation build() {
      Musicinformation musicinformation = new Musicinformation(name, time, artist,type,genre,date) {};
      return musicinformation;
  }

    
  

}
