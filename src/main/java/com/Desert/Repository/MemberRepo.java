package com.Desert.Repository;

import com.Desert.Entity.Member;

public interface MemberRepo {

    Member getMemberByEmail(String email);

    void insertMember(Member member);

    Member getMemberByUsername(String username);

    void updateMemberByUsername(Member member);

    boolean existedEmail(String email);

    boolean existedUsername(String username);
}
