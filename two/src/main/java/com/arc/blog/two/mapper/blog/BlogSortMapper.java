package com.arc.blog.two.mapper.blog;

import com.arc.blog.two.model.domain.blog.BlogSort;

import java.util.List;

/**
 * @author: 叶超
 * @since: 2019/1/30 15:05
 */
public interface BlogSortMapper {

    int save(BlogSort sort);

    int delete(Long id);

    int update(BlogSort sort);

    BlogSort get(Long id);

    List<BlogSort> list();

}
