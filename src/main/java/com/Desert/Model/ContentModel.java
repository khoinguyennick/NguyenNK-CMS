package com.Desert.Model;

import com.Desert.Validator.UnusedTitle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ContentModel {

    @NotNull
    @Length(min = 10, max = 200)
    @UnusedTitle
    private String title;
    @NotNull
    @Length(min = 30, max = 150)
    private String brief;
    @NotNull
    @Length(min = 50, max = 1000)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
