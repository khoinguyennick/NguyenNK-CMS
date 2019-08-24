package com.Desert.Controller.AjaxController;

import com.Desert.Controller.PageController.ContentController;
import com.Desert.Entity.Content;
import com.Desert.Entity.Member;
import com.Desert.Model.ContentModel;
import com.Desert.Service.ContentService;
import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/ajax/content")
public class AjaxContent {

    @Autowired
    private ContentService contentService;
    @Autowired
    private MemberService memberService;


    @GetMapping("/list")
    public String list(ModelMap modelMap, Principal principal) {
        Member member = memberService.getMemberByUsername(principal.getName());
        long authorID = member.getId();
        List<Content> contentList = contentService.getContentListOfAuthor(authorID);

        modelMap.addAttribute("contentList", contentList);
        return "ajax-list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap) {
        ContentModel contentModel = new ContentModel();
        modelMap.addAttribute("contentModel", contentModel);

        return "ajax-form";
    }
}
