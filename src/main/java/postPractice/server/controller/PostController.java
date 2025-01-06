package postPractice.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import postPractice.server.domain.Post;
import postPractice.server.domain.PostRequest;
import postPractice.server.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/posts")
public class PostController {

        private final PostService postService;
        private static final Logger logger = LoggerFactory.getLogger(PostController.class);


        public PostController(PostService postService) {
            this.postService = postService;
        }

        @PostMapping
        public Post createPost(@RequestBody PostRequest request) {
            logger.debug("Received POST request with title: {}", request.getTitle()); // 로그 추가
            Post post = new Post(request.getTitle(), request.getContent(), request.getTags(), LocalDateTime.now());
            return postService.createPost(post);
        }

        @GetMapping
        public List<Post> getAllPosts() {
            List<Post> posts = postService.getAllPosts();
            posts.forEach(post -> logger.debug("Post createdAt: {}", post.getCreatedAt()));
            return postService.getAllPosts();
        }

        @GetMapping("/{id}")
        public Post getPostById(@PathVariable long id) {
            return postService.getPostById(id);
        }

        @PutMapping("/{id}")
        public Post updatePost(@PathVariable long id, @RequestBody PostRequest request) {
            return postService.updatePost(id, request);
        }

        @DeleteMapping("/{id}")
        public void deletePost(@PathVariable long id) {
            postService.deletePost(id);
        }
}
