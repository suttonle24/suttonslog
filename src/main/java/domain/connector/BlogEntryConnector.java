package domain.connector;

import domain.model.dbo.BlogEntryDbo;

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

    public BlogEntryDbo getLatestBlogEntry(){
        BlogEntryDbo latestBlog = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<BlogEntryDbo> blogEntries = new LinkedList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blog_entries ORDER BY dateCreated DESC LIMIT 1");

            if (stmt.execute("SELECT * FROM blog_entries ORDER BY dateCreated DESC LIMIT 1")) {
                rs = stmt.getResultSet();
            }



            while (rs.next()) {

                // Mapper should live here.

                long id = rs.getLong("id");
                String title = rs.getString("title");
                java.sql.Timestamp datecreated = (java.sql.Timestamp)rs.getTimestamp("dateCreated");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String contents = rs.getString("contents");

                BlogEntryDbo blogEntry = new BlogEntryDbo(id, title, datecreated, category,
                        author, contents);

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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }

        }


        return latestBlog;
    }


}
