package domain.connector;

import domain.mapper.BlogEntryResponseMapper;
import domain.model.dbo.BlogEntryDbo;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leens on 8/10/2016.
 */
public class BlogEntryConnector {

    private final String URL = System.getenv("suttonsLogQa");
    private final String USERNAME = System.getenv("suttonsLogUsername");
    private final String PASSWORD = System.getenv("suttonsLogPw");

    BlogEntryResponseMapper blogEntryResponseMapper = new BlogEntryResponseMapper();

    public BlogEntryDbo getLatestBlogEntry(){
        BlogEntryDbo latestBlog = null;
        Statement query = null;
        ResultSet queryResult = null;
        List<BlogEntryDbo> blogEntries = new LinkedList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            query = conn.createStatement();
            queryResult = query.executeQuery("SELECT * FROM blog_entries ORDER BY dateCreated DESC LIMIT 1");

            if (query.execute("SELECT * FROM blog_entries ORDER BY dateCreated DESC LIMIT 1")) {
                queryResult = query.getResultSet();
            }

            while (queryResult.next()) {

                BlogEntryDbo blogEntry = blogEntryResponseMapper.mapBlogEntryResponse(queryResult);

                try{
                    blogEntries.add(blogEntry);
                }
                catch(Exception e){
                    System.out.print(e.getMessage());
                }
            }

            try{
                latestBlog = blogEntries.get(0);
            }
            catch(Exception e){
                latestBlog = null;
                System.out.print(e.getMessage());
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally{
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException sqlEx) { } // ignore

                queryResult = null;
            }

            if (query != null) {
                try {
                    query.close();
                } catch (SQLException sqlEx) { } // ignore

                query = null;
            }

        }


        return latestBlog;
    }


}
