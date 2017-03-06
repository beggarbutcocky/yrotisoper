package com.bovt.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {})
public class Waybill {

    @GenericGenerator(
            name = "waybill_pk_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "waybill_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @NotNull
    @GeneratedValue(generator = "waybill_pk_sequence")
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name = "sum")
    private Integer sun;

    @NotNull
    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;
}
