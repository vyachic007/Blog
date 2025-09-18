package by.slava_borisov.blog.repo;

import by.slava_borisov.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
