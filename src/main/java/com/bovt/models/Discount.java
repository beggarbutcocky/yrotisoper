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
@ToString(exclude = {"id", "productCategory", "percent"})
public class Discount {

    @GenericGenerator(
            name = "discount_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "discount_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "discount_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @JoinColumn(name = "product_category_id")
    @ManyToOne
    private ProductCategory productCategory;

    @NotNull
    @Column(name = "percent")
    private Integer percent;

}
