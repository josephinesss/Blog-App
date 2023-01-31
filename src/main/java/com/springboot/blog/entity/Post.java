package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/*
   @Data offers toString method. while Post needs to get all comments which type is Comment.
   Therefore, only use Getter and Setter
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"Title"})}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Content", nullable = false)
    private String content;

    // maintain unique comments
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
