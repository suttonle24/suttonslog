package domain.model.dbo;

import domain.model.valueObject.Category;

import java.util.Date;

public class BlogEntryDbo {
  private Long id;
  private String title;
  private Date datecreated;
  private Category category;
  private String author;
  private String contents;

  public BlogEntryDbo(){}

  public BlogEntryDbo(Long id, String title, java.sql.Timestamp datecreated,
                      Category category, String author, String contents){
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

  public Date getDatecreated() {
    return datecreated;
  }

  public void setDatecreated(Date datecreated) {
    this.datecreated = datecreated;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
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
