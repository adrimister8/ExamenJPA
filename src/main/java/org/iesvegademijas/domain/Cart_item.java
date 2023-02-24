package org.iesvegademijas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id_cart")
@Builder
@Table(name = "cart_item")
public class Cart_item {
    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Product producto;

    private Long quiantity;

    private Date created_date;

    private Date modified_date;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    private User user;
}
