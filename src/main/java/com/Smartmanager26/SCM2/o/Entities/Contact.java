package com.Smartmanager26.SCM2.o.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "contact")
@Getter
@Setter
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    private String description;
    private boolean favorite = false;
    private String websiteLink;
    private String linkedinLink;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "userid", nullable = false)
    private User user;

    @OneToMany(mappedBy = "userboya", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
private List<SocialLink> links = new ArrayList<>();

}
