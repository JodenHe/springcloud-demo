/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.joden123.authuserservice.domain.entity.User;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/10
 *
 * @author xiaofeng.he
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
