package com.Desert.Service;

import com.Desert.Entity.Content;
import com.Desert.Repository.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContentServiceBean implements ContentService {

    @Autowired
    private ContentRepo contentRepo;

    @Override
    public List<Content> getContentListOfAuthor(long authorID) {
        return contentRepo.getContentListOfAuthor(authorID);
    }

    @Override
    public List<Content> searchContent(long authorID, String keyword) {
        return contentRepo.searchContent(authorID, keyword);
    }

    @Override
    public void insertContent(Content content) {
        contentRepo.insertContent(content);
    }

    @Override
    public boolean existedTitle(String title) {
        return contentRepo.existedTitle(title);
    }
}
