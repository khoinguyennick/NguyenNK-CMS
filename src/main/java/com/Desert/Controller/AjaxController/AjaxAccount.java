package com.Desert.Controller.AjaxController;

import com.Desert.Controller.PageController.ContentController;
import com.Desert.Entity.Member;
import com.Desert.Model.MemberModel;
import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/ajax/account")
public class AjaxAccount {

    @Autowired
    private MemberService memberService;

    @GetMapping("/profile")
    public String edit(Principal principal, ModelMap modelMap) {
        Member member = memberService.getMemberByUsername(principal.getName());

        MemberModel memberModel = new MemberModel(member);
        modelMap.addAttribute("memberModel", memberModel);
        return "ajax-profile";
    }
}
