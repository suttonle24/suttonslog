package suttonsLog.domain.service;

import suttonsLog.domain.model.BlogEntry;

import java.util.List;

/**
 * Created by leens on 8/11/2016.
 */
public interface IBlogService {
    public BlogEntry getLatestBlogEntry();
    public List<BlogEntry> getAllBlogEntries();
}
