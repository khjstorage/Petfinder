package com.petfinder.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.petfinder.dto.MemberDto;

public interface MemberService {
    ArrayList<MemberDto> getMembers();
    void insertMember(Model model);	
    void updateMember(String name);
    void deleteMember(String name);
}
