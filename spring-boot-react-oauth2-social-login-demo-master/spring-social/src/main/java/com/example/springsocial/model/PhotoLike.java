package com.example.springsocial.model;

import javax.persistence.*;

@Entity
//@JsonidentityInfo( generator = ObjectIdgenerators.PropertyGenerator.class, property="id")
public class PhotoLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName="id")
    private User owner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="photo", referencedColumnName="id")
    private Photo photo;

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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
