package com.indu.service;

import java.util.List;

import com.indu.exception.IssueException;
import com.indu.exception.UserException;
import com.indu.model.Comment;

public interface CommentService {
    Comment createComment(Long issueId,Long userId,String comment) throws UserException, IssueException;

    void  deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}
