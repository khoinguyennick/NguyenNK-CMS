package com.Desert.Repository;

import com.Desert.Entity.Content;

import java.util.List;

public interface ContentRepo {

    List<Content> getContentListOfAuthor(long authorID);

    List<Content> searchContent(long authorID, String keyword);

    void insertContent(Content content);

    boolean existedTitle(String title);
}
