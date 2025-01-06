package postPractice.server.repository;

import org.springframework.stereotype.Repository;
import postPractice.server.domain.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Post save(Post post) {
        post.setId(counter.getAndIncrement());
        posts.add(post);
        return post;
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst();
    }

    public void deleteById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}
