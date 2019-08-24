package com.Desert.Controller.PageController;

import com.Desert.Entity.Content;
import com.Desert.Entity.Member;
import com.Desert.Model.ContentModel;
import com.Desert.Service.ContentService;
import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private MemberService memberService;

    private long authorID;

    @GetMapping("")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Member member = memberService.getMemberByUsername(username);
        this.authorID = member.getId();

        return "home";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        List<Content> contentList = contentService.getContentListOfAuthor(authorID);
        modelMap.addAttribute("contentList", contentList);

        return "list";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, ModelMap modelMap) {
        List<Content> contentList = contentService.searchContent(authorID, keyword);
        modelMap.addAttribute("contentList", contentList);

        return "list";
    }

    @GetMapping("/form")
    public String form(ModelMap modelMap) {
        ContentModel contentModel = new ContentModel();
        modelMap.addAttribute("contentModel", contentModel);

        return "form";
    }

    @PostMapping("/insert-content")
    public String insertContent(@Valid @ModelAttribute("contentModel") ContentModel contentModel,
                                BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("notification", "Insert Error!");
            return "form";
        } else {
            Content content = new Content();
            content.setAuthorId(authorID);
            content.setTitle(contentModel.getTitle());
            content.setBrief(contentModel.getBrief());
            content.setContent(contentModel.getContent());
            content.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
            content.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));

            contentService.insertContent(content);
            return "redirect:/list";
        }
    }
}
