package io.github.susimsek.springkafkasamples.dto;

import java.util.Comparator;

public class PostDTOComparator implements Comparator<PostDTO> {

    @Override
    public int compare(PostDTO o1, PostDTO o2) {
        return o1.compareTo(o2);
    }
}