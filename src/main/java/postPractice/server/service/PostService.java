package postPractice.server.service;

import org.springframework.stereotype.Service;
import postPractice.server.domain.Post;
import postPractice.server.domain.PostRequest;
import postPractice.server.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post request) {
        return postRepository.save(new Post(
                request.getTitle(),
                request.getContent(),
                request.getTags(),
                LocalDateTime.now()
        ));
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public Post updatePost(long id, PostRequest request) {
        Post post = getPostById(id);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setTags(request.getTags());
        return post;
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
