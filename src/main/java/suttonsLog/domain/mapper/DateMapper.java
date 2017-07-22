package suttonsLog.domain.mapper;

import suttonsLog.domain.model.BlogDate;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leens on 8/13/2016.
 */
public class DateMapper {
    public BlogDate mapBlogDate(Date datecreated){
        BlogDate blogDate = new BlogDate();

        Format formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateString = formatter.format(datecreated);

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
