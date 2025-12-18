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

    /*
     * 获取标签列表接口
     * @author Yuc
     * @param pageNum 页码，默认1
     * @param pageSize 每页数量，默认10
     * @return 标签列表
     * */
    public List<Tag> getTagList(int pageNum, int pageSize) {
        return tagMapper.selectTagList(pageNum, pageSize);
    }

    /*
     * 删除商品标签接口
     * @author Yuc
     * @param id 标签ID
     * @return 删除结果
     * */

}


