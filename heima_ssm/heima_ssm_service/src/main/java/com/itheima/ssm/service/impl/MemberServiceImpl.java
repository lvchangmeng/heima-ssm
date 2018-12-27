package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.MemberDao;
import com.itheima.ssm.domain.Member;
import com.itheima.ssm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public Member findById(String id) {
        return memberDao.findById(id);
    }
}
