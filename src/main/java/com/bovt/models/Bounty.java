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
@ToString(exclude = {"orders"})
public class Bounty {

    @GenericGenerator(
            name = "bounty_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "bounty_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "bounty_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @NotNull
    @JoinColumn(name = "shop_mention_id")
    @ManyToOne
    private ShopMention shopMention;

    @NotNull
    @Column(name = "sum")
    private Integer sum;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "orderItem")
    private Set<Order> orders = new HashSet<>();
}
