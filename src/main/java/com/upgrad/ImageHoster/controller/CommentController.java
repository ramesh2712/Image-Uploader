package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CommentController {


    @Autowired
    private ImageService imageService;


    @Autowired
    private CommentService commentService;

    // click on submit button

    /**
     * This controller method displays an image edit form, so the user
     * can update the image's description and uploaded file
     *
     * @param id id of the image that we want to add comment
     * @param title title of the image that we want to add comment
     * @param text Received text of the image that we want to add comment
     *
     * @return the image edit form view
     */

    @RequestMapping(value = "/image/{id}/{title}/comments/create", method = RequestMethod.POST)
    public String submitComment(@PathVariable Integer id,
                                @PathVariable String title,
                                @RequestParam("comment") String text,
                                HttpSession session) throws IOException {

        User currUser = (User) session.getAttribute("currUser");

        // if the user is not logged in, redirect to the home page
        if(currUser == null ){
            return "redirect:/";
        }
        else {

            // create/add comment into database ...
            Image image = imageService.getByID(id);
            Comment comment = new Comment();
            comment.setImage(image);
            comment.setText(text);
            comment.setUser(currUser);
            commentService.createComment(comment);
            return "redirect:/images/" + id + "/" + title;
        }
    }
}
