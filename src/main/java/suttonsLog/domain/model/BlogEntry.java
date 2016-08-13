package suttonsLog.domain.model;

public class BlogEntry {
  private Long id;
  private String title;
  private BlogDate blogDate;
  private String category;
  private String author;
  private String contents;

  public BlogEntry(){}

  public BlogEntry(Long id, String title, BlogDate blogDate,
            String category, String author, String contents){
      this.id = id;
      this.title = title;
      this.blogDate = blogDate;
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

  public BlogDate getBlogDate() {
    return blogDate;
  }

  public void setBlogDate(BlogDate blogDate) {
    this.blogDate = blogDate;
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
