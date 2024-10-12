package com.Smartmanager26.SCM2.o.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SocialLink {
    @Id
    private Long id;
    private String link;  // Consider using camelCase
    private String title; // Consider using camelCase

    @ManyToOne
    private Contact userboya; // Ensure this is the right reference
}
