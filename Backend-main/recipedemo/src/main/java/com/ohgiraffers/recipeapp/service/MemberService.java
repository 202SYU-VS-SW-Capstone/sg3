package com.ohgiraffers.recipeapp.service;

import com.ohgiraffers.recipeapp.entity.Member;
import com.ohgiraffers.recipeapp.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // MemberRepository를 생성자로 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 모든 회원 조회
     *
     * @return List<Member> - 모든 회원 목록
     */
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * ID로 특정 회원 조회
     *
     * @param id 회원 ID
     * @return Member - 조회된 회원 데이터
     * @throws IllegalArgumentException - 해당 ID의 회원이 없을 경우 예외 발생
     */
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + id));
    }

    /**
     * 특정 회원 정보 수정
     *
     * @param id 수정할 회원 ID
     * @param updatedMember 수정할 회원 데이터
     * @return Member - 수정된 회원 데이터
     */
    public Member updateMember(Long id, Member updatedMember) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + id));
        existingMember.setUsername(updatedMember.getUsername());
        existingMember.setEmail(updatedMember.getEmail());
        return memberRepository.save(existingMember);
    }

    /**
     * 특정 회원 삭제
     *
     * @param id 삭제할 회원 ID
     */
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
