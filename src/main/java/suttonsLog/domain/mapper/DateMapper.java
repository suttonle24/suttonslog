package suttonsLog.domain.mapper;

import suttonsLog.domain.model.BlogDate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leens on 8/13/2016.
 */
public class DateMapper {
    public BlogDate mapBlogDate(java.sql.Timestamp datecreated){
        BlogDate blogDate = new BlogDate();

        long milliseconds = datecreated.getTime() + (datecreated.getNanos() / 1000000);
        Date date = new Date(milliseconds);

        Format formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(date);


        String day = dateString.substring(3, 5);
        String month = dateString.substring(0, 2);
        String year = dateString.substring(6, 10);
        String time = dateString.substring(11);

        blogDate.setDay(day);
        blogDate.setMonth(month);
        blogDate.setYear(year);
        blogDate.setTime(time);

        return  blogDate;
    }
}
