package io.github.susimsek.springkafkasamples.controller;

import io.github.susimsek.springkafkasamples.dto.PostDTO;
import io.github.susimsek.springkafkasamples.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "collection",
    description = "Java Collections demo REST APIs"
)
@RestController
@RequestMapping(value = "/api/v1/collection")
@RequiredArgsConstructor
public class CollectionSampleController {

    private final PostService postService;

    @GetMapping("/post-set")
    public Set<PostDTO> getPostSet(){
        return postService.getPostSet();
    }

    @GetMapping("/post-tree-set")
    public Set<PostDTO> getPostTreeSet(){
        return postService.getPostTreeSet();
    }

    @GetMapping("/post-list")
    public List<PostDTO> getPostList(){
        return postService.getPostList();
    }

    @GetMapping("/post-list-stream")
    public List<PostDTO> getPostListWithStream(){
        return postService.getPostListWithStream();
    }

    @GetMapping("/post-list-stream-comparator")
    public List<PostDTO> getPostListWithStreamComparator(){
        return postService.getPostListWithStreamComparator();
    }
}