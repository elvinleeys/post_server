package postPractice.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Post {
    @Setter
    private long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private List<String> tags;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    public Post(String title, String content, List<String> tags, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.createdAt = createdAt;
    }

}
