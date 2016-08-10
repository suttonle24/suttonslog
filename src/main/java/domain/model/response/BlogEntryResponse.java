package domain.model.response;

import com.sun.istack.internal.Nullable;
import domain.model.dbo.BlogEntryDbo;

public class BlogEntryResponse {
  private BlogEntryDbo blogEntryDbo;
  private Boolean successful;
  private String errorMessage;

  public BlogEntryResponse(BlogEntryDbo blogEntryDbo, @Nullable Boolean successful, @Nullable String errorMessage){
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
