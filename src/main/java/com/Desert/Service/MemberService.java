package com.Desert.Service;

import com.Desert.Entity.Member;

public interface MemberService {

    void insertMember(Member member);

    Member getMemberByUsername(String username);

    void updateMemberByUsername(Member member);

    boolean existedEmail(String email);

    boolean existedUsername(String username);
}
