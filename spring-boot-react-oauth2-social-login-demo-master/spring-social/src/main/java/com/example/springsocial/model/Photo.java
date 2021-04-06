package com.example.springsocial.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName="id")
    private User owner;

    @Lob
    private byte[] picture;

    private String description;

    @OneToMany(mappedBy="photo", cascade = ALL)
    private List<PhotoLike> photoLikes;

    @OneToMany(mappedBy="photo", cascade = ALL)
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PhotoLike> getPhotoLikes() {
        return photoLikes;
    }

    public void setPhotoLikes(List<PhotoLike> photoLikes) {
        this.photoLikes = photoLikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
