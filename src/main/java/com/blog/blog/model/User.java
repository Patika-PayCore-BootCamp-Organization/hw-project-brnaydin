package com.blog.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name="tbl_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name="status", referencedColumnName ="code" )
    private DictStatusUser status;

    @ManyToOne
    @JoinColumn(name="type", referencedColumnName ="code" )
    private DictTypeUser type;

    private Date createdAt;

    private Date updatedAt;

    private Long createdBy;

    private Long updatedBy;

    public User(){
        onCreate();
    }

    public void onCreate()
    {
        this.setCreatedBy(-1L);
        this.setCreatedAt(new Date());
    }

    @PreUpdate
    public void onUpdate()
    {
        this.setUpdatedBy(-1L);
        this.setUpdatedAt(new Date());
    }

}
