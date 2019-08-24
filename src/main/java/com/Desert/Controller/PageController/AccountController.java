package com.Desert.Controller.PageController;

import com.Desert.Entity.Authority;
import com.Desert.Entity.Member;
import com.Desert.Model.MemberModel;
import com.Desert.Model.RegisterModel;
import com.Desert.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

@Controller
public class AccountController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private RegisterModel registerModel;

    @InitBinder
    public void trimString(WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap modelMap) {
        this.registerModel = new RegisterModel();
        modelMap.addAttribute("registerModel", registerModel);
        return "register";
    }

    @PostMapping("/create-member")
    public String create(@Valid @ModelAttribute("registerModel") RegisterModel registerModel, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            this.registerModel = registerModel;
            modelMap.addAttribute("registerModel", registerModel);
            return "register";
        }

        Member member = new Member();
        member.setUsername(registerModel.getUsername());
        member.setPassword(passwordEncoder.encode(registerModel.getPassword()));
        member.setEmail(registerModel.getEmail());
        member.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        member.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));
        member.setAuthorities(Collections.singletonList(new Authority(1, "AUTHOR")));
        memberService.insertMember(member);

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        member.getEmail(),
                        member.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String edit(ModelMap modelMap, Principal principal) {
        Member member = memberService.getMemberByUsername(principal.getName());

        MemberModel memberModel = new MemberModel(member);
        modelMap.addAttribute("memberModel", memberModel);
        return "profile";
    }

    @PostMapping("/update-profile")
    public String update(@Valid @ModelAttribute("memberModel") MemberModel memberModel,
                         BindingResult bindingResult, ModelMap modelMap, Principal principal) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("memberModel", memberModel);
        } else {
            Member member = memberService.getMemberByUsername(principal.getName());
            member.setFirstName(memberModel.getFirstName());
            member.setLastName(memberModel.getLastName());
            member.setPhone(memberModel.getPhone());
            member.setDescription(memberModel.getDescription());
            member.setUpdatedTime(Timestamp.valueOf(LocalDateTime.now()));
            memberService.updateMemberByUsername(member);

            modelMap.addAttribute("notification", "Profile updated!");
        }

        return "profile";
    }
}
