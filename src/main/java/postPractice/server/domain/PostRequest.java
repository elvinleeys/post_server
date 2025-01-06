package postPractice.server.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class PostRequest {
    private String title;
    private String content;
    private List<String> tags;

}
