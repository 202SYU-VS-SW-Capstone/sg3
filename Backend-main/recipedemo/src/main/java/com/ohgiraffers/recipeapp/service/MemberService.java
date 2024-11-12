package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Member;
import com.ohgiraffers.recipeapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        return memberRepository.findById(id)
                .map(member -> {
                    member.setUsername(updatedMember.getUsername());
                    member.setEmail(updatedMember.getEmail());
                    member.setPassword(updatedMember.getPassword());
                    member.setRole(updatedMember.getRole());
                    return memberRepository.save(member);
                })
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
