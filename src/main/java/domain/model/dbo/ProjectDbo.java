package domain.model.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDbo {
    private String banner_alt;
    private String banner_img;
    private int sort_order;
    private String content_link;

    public ProjectDbo(){}

    public ProjectDbo(String banner_alt, String banner_img, int sort_order, String content_link) {
        this.banner_alt = banner_alt;
        this.banner_img = banner_img;
        this.sort_order = sort_order;
        this.content_link = content_link;
    }

    public String getBanner_alt() {
        return banner_alt;
    }

    public String getBanner_img() {
        return banner_img;
    }

    public int getSort_order() {
        return sort_order;
    }

    public String getContent_link() {
        return content_link;
    }
}