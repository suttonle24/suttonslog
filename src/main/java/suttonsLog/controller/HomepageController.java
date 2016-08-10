package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import suttonsLog.model.BlogEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leens on 7/20/2016.
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        Statement stmt = null;
        ResultSet rs = null;

        String url = System.getenv("suttonsLogQa");
        String username = System.getenv("suttonsLogUsername");
        String password = System.getenv("suttonsLogPw");
        List<BlogEntry> blogEntries = new LinkedList<>();
        String contentHtml = null;

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blog_entries");

            if (stmt.execute("SELECT * FROM blog_entries")) {
                rs = stmt.getResultSet();
            }



            while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                java.sql.Timestamp datecreated = (java.sql.Timestamp)rs.getTimestamp("dateCreated");
                String category = rs.getString("category");
                String author = rs.getString("author");
                String contents = rs.getString("contents");

                BlogEntry blogEntry = new BlogEntry(id, title, datecreated, category,
                        author, contents);

                try{
                    blogEntries.add(blogEntry);
                }
                catch(Exception e){
                    System.out.print(e.getMessage());
                }
            }

            try{
                contentHtml = blogEntries.get(0).getContents();
            }
            catch(Exception e){
                System.out.print(e.getMessage());
            }

            model.addAttribute("blogContent", contentHtml);

            // Do something with the Connection

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

        model.addAttribute("name", name);
        return "index";
    }

}
