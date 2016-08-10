package domain.service;

import domain.model.response.BlogEntryResponse;

/**
 * Created by leens on 8/10/2016.
 */
public interface IBlogEntryService {
    public BlogEntryResponse GetLatestBlogEntry();
}
