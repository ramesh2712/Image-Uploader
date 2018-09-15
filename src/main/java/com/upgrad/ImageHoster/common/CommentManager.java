package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Session;

import java.util.List;

public class CommentManager extends SessionManager{

    public void createComment(final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }
}
