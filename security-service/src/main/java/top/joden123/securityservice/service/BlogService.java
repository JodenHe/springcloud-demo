/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.securityservice.service;

import org.springframework.stereotype.Service;
import top.joden123.securityservice.domain.Blog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 博客
 * <p>
 * Created by xiaofeng.he on 2021/04/10
 *
 * @author xiaofeng.he
 */
@Service
public class BlogService {

    private List<Blog> list = new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1L, "spring in action", "good!"));
        list.add(new Blog(2L, "spring boot in action", "nice!"));
    }

    public List<Blog> getBlogs() {
        return list;
    }

    public void deleteBlog(long id) {
        Iterator<Blog> iter = list.iterator();
        while (iter.hasNext()) {
            Blog blog = iter.next();
            if (blog.getId() == id) {
                iter.remove();
            }
        }
    }

}
