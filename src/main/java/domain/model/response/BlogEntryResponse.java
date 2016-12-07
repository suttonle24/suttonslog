package domain.model.response;

import domain.model.dbo.BlogEntryDbo;

import java.util.List;

public class BlogEntryResponse {
  private BlogEntryDbo blogEntryDbo;
  private List<BlogEntryDbo> blogEntries;
  private Boolean successful;
  private String errorMessage;

  public BlogEntryResponse(BlogEntryDbo blogEntryDbo){
    this.blogEntryDbo = blogEntryDbo;
  }

  public BlogEntryResponse(BlogEntryDbo blogEntryDbo, Boolean successful, String errorMessage){
    this.blogEntryDbo = blogEntryDbo;
    this.successful = successful;
    this.errorMessage = errorMessage;
  }


    public BlogEntryResponse(List<BlogEntryDbo> blogEntries){
        this.blogEntries = blogEntries;
    }

  public BlogEntryResponse(List<BlogEntryDbo> blogEntries, Boolean successful, String errorMessage){
    this.blogEntries = blogEntries;
    this.successful = successful;
    this.errorMessage = errorMessage;
  }

  public List<BlogEntryDbo> getBlogEntries() {
    return blogEntries;
  }

  public BlogEntryDbo getBlogEntryDbo() {
    return blogEntryDbo;
  }

  public Boolean getSuccessful() {
    return successful;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
