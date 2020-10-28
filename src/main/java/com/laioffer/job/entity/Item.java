package com.laioffer.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true) //没有cover所有的field，还有其他的field 什么create什么
//如果不specify这个

//防止没有setfavirote或者null的时候 会在结果里显示
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    private String id;
    private String title;
    private String location;
    private String companyLogo;
    private String url;
    private String description;
    //上面的是根据github response的关键字定义的
    //这两个以后会用
    private Set<String> keywords;
    private boolean favorite;

    //add constructor for Item
    public Item() {
    }

    public Item(String id, String title, String location, String companyLogo, String url, String description, Set<String> keywords, boolean favorite) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.companyLogo = companyLogo;
        this.url = url;
        this.description = description;
        this.keywords = keywords;
        this.favorite = favorite;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    //没有equals的话 default比较用reference 是比较memory address 即使内容一样 返回也是不一样的
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return favorite == item.favorite &&
                Objects.equals(id, item.id) &&
                Objects.equals(title, item.title) &&
                Objects.equals(location, item.location) &&
                Objects.equals(companyLogo, item.companyLogo) &&
                Objects.equals(url, item.url) &&
                Objects.equals(description, item.description) &&
                Objects.equals(keywords, item.keywords);
    }

    @Override
    //model class 鼓励生成hashcode和equals 好的code会自动生成
    public int hashCode() {
        return Objects.hash(id, title, location, companyLogo, url, description, keywords, favorite);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", companyLogo='" + companyLogo + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", keywords=" + keywords +
                ", favorite=" + favorite +
                '}';
    }



}

    //为什么item需要 annotation
    //jackson是通过reflection读的 读不到private的

    //@JsonIgnoreProperties(ignoreUnknown = true)
    //indicates that other fields in the response can be safely ignored.
    //    Without this, you'll get an exception at runtime.
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    //indicates that null fields can be skipped and not included.
    //@JsonProperty("") indicates the mapping,
    //the extact match is not required, but it's required for
    //multi-word snake case and camel case conversions, like company_log to companyLogo.

