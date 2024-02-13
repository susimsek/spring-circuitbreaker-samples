package io.github.susimsek.springkafkasamples.service;

import io.github.susimsek.springkafkasamples.dto.PostDTO;
import io.github.susimsek.springkafkasamples.dto.PostDTOComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private static final PostDTO  POST_1  = new PostDTO("1", 1L,
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        """
    quia et suscipit
    suscipit recusandae consequuntur expedita et cum
    reprehenderit molestiae ut ut quas totam
    nostrum rerum est autem sunt rem eveniet architecto""");
    private static final PostDTO  POST_2 = new PostDTO("1", 2L,
        "qui est esse",
        """
            est rerum tempore vitae
            sequi sint nihil reprehenderit dolor beatae ea dolores neque
            fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis
            qui aperiam non debitis possimus qui neque nisi nulla""");

    public Set<PostDTO> getPostSet()  {
        var set = new HashSet<PostDTO>();
        set.add(POST_1);
        set.add(POST_2 );
        return set;
    }

    public Set<PostDTO> getPostTreeSet()  {
        var set = new TreeSet<PostDTO>();
        set.add(POST_1);
        set.add(POST_2 );
        return set;
    }

    public List<PostDTO> getPostListWithStream()  {
        var list = new ArrayList<PostDTO>();
        list.add(POST_1);
        list.add(POST_2 );
        return list.stream()
            .sorted().toList();
    }

    public List<PostDTO> getPostList() {
        var list = new ArrayList<PostDTO>();
        list.add(POST_1);
        list.add(POST_2 );
        Collections.sort(list);
        return list;
    }

    public List<PostDTO> getPostListWithStreamComparator() {
        var list = new ArrayList<PostDTO>();
        list.add(POST_1);
        list.add(POST_2 );
        return list.stream()
            .sorted(new PostDTOComparator().reversed())
            .toList();
    }
}