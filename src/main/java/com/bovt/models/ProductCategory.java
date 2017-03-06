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
@ToString(exclude = {"productCategories"})
@Table(name = "product_category")
public class ProductCategory {

    @GenericGenerator(
            name = "product_category_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_category_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "product_category_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @JoinColumn(name = "filter_id")
    @ManyToOne
    private Filter filter;

    @JoinColumn(name = "parent_category_id")
    @ManyToOne
    private ProductCategory productCategory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productCategory")
    private Set<ProductCategory> productCategories = new HashSet<>();

/*    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "discountProductCategory")
    private Set<ProductCategory> discountProductCategories = new HashSet<>();*/
}
