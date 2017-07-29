package suttonsLog.domain.model;

import domain.model.valueObject.Category;

public class BlogEntry {
  private String title;
  private BlogDate blogDate;
  private Category category;
  private String author;
  private String contents;

  public BlogEntry(){}

  public BlogEntry(String title, BlogDate blogDate,
            Category category, String author, String contents){
      this.title = title;
      this.blogDate = blogDate;
      this.category = category;
      this.author = author;
      this.contents = contents;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BlogDate getBlogDate() {
    return blogDate;
  }

  public void setBlogDate(BlogDate blogDate) {
    this.blogDate = blogDate;
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
