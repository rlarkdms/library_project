package com.example.dao;

import com.example.data.Member;
import com.example.data.RegisterRequest;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String regist(RegisterRequest req) throws Exception {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new Exception("DuplicateMemberException");
        }
        System.out.print("저장 부분까지 들어왔다.");
        System.out.print(req.getId()+req.getEmail()+req.getPassword()+ 
				req.getName()+req.getPhone());
        
        Member newMember = new Member( req.getId(),req.getEmail(), req.getPassword(), 
				req.getName(), req.getPhone());
        
        memberDao.insert(newMember);
        return newMember.getId();
    }

}
