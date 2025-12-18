package com.example.shop.service;

import com.example.shop.entity.Tag;
import com.example.shop.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagMapper tagMapper;

    /*
     * 创建标签接口
     * @author Yuc
     * @param tag 标签信息
     * @return 新增结果
     * */
    public boolean createTag(Tag tag) {
        return tagMapper.insert(tag) > 0;
    }
}


