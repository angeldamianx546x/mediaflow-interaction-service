package com.mediaflow.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mediaflow.api.model.Comment;

public interface CommentService {
    Page<Comment> findByContentId(Integer contentId, Pageable pageable);

    Comment create(Comment comment);

    void delete(Integer commentId);

    Comment findById(Integer commentId);
}
