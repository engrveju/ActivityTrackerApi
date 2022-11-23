package com.dev.activitytracker.pojos;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "satus")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "completed_at")
    private Date completedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User users;
}
