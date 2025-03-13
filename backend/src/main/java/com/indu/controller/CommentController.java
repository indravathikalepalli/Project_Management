package com.indu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.indu.exception.IssueException;
import com.indu.exception.ProjectException;
import com.indu.exception.UserException;
import com.indu.model.Comment;
import com.indu.model.User;
import com.indu.request.CreateCommentRequest;
import com.indu.response.MessageResponse;
import com.indu.service.CommentService;
import com.indu.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;
    private UserService userService;

    @Autowired
    public CommentController(CommentService commentService,UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Comment> createComment(

            @RequestBody CreateCommentRequest req,
            @RequestHeader("Authorization") String jwt) throws UserException, IssueException, ProjectException {
        User user = userService.findUserProfileByJwt(jwt);
        Comment createdComment = commentService.createComment(req.getIssueId(), user.getId(), req.getContent());
        return new ResponseEntity<>(createdComment,HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<MessageResponse> deleteComment(@PathVariable Long commentId,

                                                         @RequestHeader("Authorization") String jwt) throws UserException, IssueException, ProjectException {
        User user = userService.findUserProfileByJwt(jwt);
        commentService.deleteComment(commentId, user.getId());
        MessageResponse res=new MessageResponse();
        res.setMessage("comment deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity<List<Comment>>  getCommentsByIssueId(@PathVariable Long issueId) {
        List<Comment> comments = commentService.findCommentByIssueId(issueId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
}
