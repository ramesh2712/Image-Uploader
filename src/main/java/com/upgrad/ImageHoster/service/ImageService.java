package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Image;

import java.util.List;

public interface ImageService{
    List<Image> getAll();
    List<Image> getByTag(String tagName);
    Image getByTitle(String title);
    Image getByTitleWithJoin(String title);
    // add new method to fetch image by id ;
    Image getByID(int id);
    void deleteByTitle(Image image);
    // Added new method to delete image by id;
    void deleteById(Image image);
    void save(Image image);
    void update(Image image);
}