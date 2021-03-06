package com.arc.blog.two.service.blog;

import com.arc.blog.two.model.domain.blog.BlogTag;

import java.util.List;

/**
 * @author 叶超
 * @since 2019/1/30 17:33
 */
public interface BlogTagService {

    Long save(BlogTag tag);

    int delete(Long id);

    int update(BlogTag tag);

    BlogTag get(Long id);

    List<BlogTag> list();
}
