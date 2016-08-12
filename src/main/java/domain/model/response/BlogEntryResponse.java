package domain.model.response;

import domain.model.dbo.BlogEntryDbo;

public class BlogEntryResponse {
  private BlogEntryDbo blogEntryDbo;
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
