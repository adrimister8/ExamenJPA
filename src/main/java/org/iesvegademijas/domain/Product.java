package org.iesvegademijas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = "id_product")
@Builder
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    private String name;

    private String descrip;

    private String image_url;

    private String sku;

    private BigDecimal price;

    private Long quiantity;

    @ManyToOne()
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Cart_item> cartItems;
}
