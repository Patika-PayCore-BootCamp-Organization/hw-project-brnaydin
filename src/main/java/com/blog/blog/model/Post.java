package com.blog.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName ="id" )
    private Post parentId;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name="status", referencedColumnName ="code" )
    private DictStatusPost status;

    @ManyToOne
    @JoinColumn(name="type", referencedColumnName ="code" )
    private DictTypePost type;

    private Long authorId;

    private Date createdAt;

    private Date updatedAt;

    private Long createdBy;

    private Long updatedBy;

}
