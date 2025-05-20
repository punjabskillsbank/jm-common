package com.common.entity;

import com.common.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "freelancers")
@Builder(toBuilder = true)
public class Freelancer {

    @Id
    @Column(nullable = false, name = "freelancer_id", updatable = false)
    private UUID freelancerId;

    @Column(name = "title")
    private String title;

    @Column(name = "bio")
    private String bio;

    @Column(name = "hourly_rate")
    private int hourlyRate;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_abc_member")
    private Boolean isAbcMember;

    @Column(name = "profile_photo_url")
    private String profilePhotoURL;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Job> jobs;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Certificate> certificates;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "profile_status", columnDefinition = "profile_status")
    private ProfileStatus profileStatus;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
