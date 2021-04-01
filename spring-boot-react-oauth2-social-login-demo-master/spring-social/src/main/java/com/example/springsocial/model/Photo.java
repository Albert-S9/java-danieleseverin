package com.example.springsocial.model;

import java.util.Date;
import java.util.List;

public class Photo {

    private User owner;
    private byte[] picture;
    private String description;

    private List<PhotoLike> photoLikes;
    private List<Comment> comments;
    private Date date;


}
