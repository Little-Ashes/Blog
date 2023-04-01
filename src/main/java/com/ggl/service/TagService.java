package com.ggl.service;

import com.ggl.domain.Tag;
import com.ggl.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTags(Long id);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

    Tag getTagByName(String name);

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);
}
