package suttonsLog.domain.model;

public class Project {
    private String bannerAlt;
    private String bannerImg;
    private int sortOrder;
    private String contentLink;

    public Project(){}

    public Project(String bannerAlt, String bannerImg, int sortOrder, String contentLink) {
        this.bannerAlt = bannerAlt;
        this.bannerImg = bannerImg;
        this.sortOrder = sortOrder;
        this.contentLink = contentLink;
    }

    public String getBannerAlt() {
        return bannerAlt;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public String getContentLink() {
        return contentLink;
    }

    public void setBannerAlt(String bannerAlt) {
        this.bannerAlt = bannerAlt;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void setContentLink(String contentLink) {
        this.contentLink = contentLink;
    }
}
