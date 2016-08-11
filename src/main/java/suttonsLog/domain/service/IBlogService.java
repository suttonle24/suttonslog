package suttonsLog.domain.service;

import suttonsLog.domain.model.BlogEntry;

/**
 * Created by leens on 8/11/2016.
 */
public interface IBlogService {
    public BlogEntry getLatestBlogEntry();
}
