package com.binary.service;

import com.binary.entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();
    Member createMember(Member member);
    Member updateMember(int id, Member updatedMember);
    Integer deleteMember(int id);
    Member getMemberById(int id);
    Member getMemberByEmail(String email);
}
