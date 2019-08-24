package com.Desert.Service;

import com.Desert.Entity.Member;
import com.Desert.Repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberServiceBean implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public void insertMember(Member member) {
        memberRepo.insertMember(member);
    }

    @Override
    public Member getMemberByUsername(String username) {
        return memberRepo.getMemberByUsername(username);
    }

    @Override
    public void updateMemberByUsername(Member member) {
        memberRepo.updateMemberByUsername(member);
    }

    @Override
    public boolean existedEmail(String email) {
        return memberRepo.existedEmail(email);
    }

    @Override
    public boolean existedUsername(String username) {
        return memberRepo.existedUsername(username);
    }
}
