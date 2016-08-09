package suttonsLog;

public class BlogEntry {
  private Long id;
  private String title;
  private java.sql.Timestamp datecreated;
  private String category;
  private String author;
  private String contents;

  BlogEntry(Long id, String title, java.sql.Timestamp datecreated,
            String category, String author, String contents){
      this.id = id;
      this.title = title;
      this.datecreated = datecreated;
      this.category = category;
      this.author = author;
      this.contents = contents;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public java.sql.Timestamp getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(java.sql.Timestamp datecreated) {
    this.datecreated = datecreated;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }
}
