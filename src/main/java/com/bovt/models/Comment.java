package com.bovt.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userClaims"})
public class Comment {

    @GenericGenerator(
            name = "comment_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "comment_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "comment_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "comment_text")
    private String commentText;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @NotNull
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comment")
    private Set<UserClaim> userClaims = new HashSet<>();

}
