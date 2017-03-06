package com.bovt.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {})
@Table(name = "product_in_shop")
public class ProductInShop {

    @GenericGenerator(
            name = "product_in_shop_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_in_shop_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "product_in_shop_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @JoinColumn(name = "shop_id")
    @ManyToOne
    private Shop shop;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @NotNull
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @NotNull
    @Column(name = "amount")
    private Integer amount;
}
