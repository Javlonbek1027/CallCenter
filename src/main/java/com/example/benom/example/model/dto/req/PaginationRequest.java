package com.example.benom.example.model.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequest {
    private int page;

    private int size = 10;

    private String search;

    private LocalDate fromDate;

    private LocalDate toDate;

    private boolean isInAscOrder = false;

    public int getPage() {
        return Math.max(page, 0);
    }

    public Pageable getPageRequest() {
        var sort = Sort.by(isInAscOrder? Direction.ASC: Direction.DESC,"createdAt");
        return PageRequest.of(getPage(), getSize(),sort);
    }
}
