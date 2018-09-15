package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.common.CommentManager;
import com.upgrad.ImageHoster.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService{

    private CommentManager commentManager;

    public CommentServiceImp() {
        commentManager = new CommentManager();
    }

    @Override
    public void createComment(Comment comment) {
        commentManager.createComment(comment);
    }

}
