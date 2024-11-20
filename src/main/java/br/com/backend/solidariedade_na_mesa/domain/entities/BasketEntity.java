package br.com.backend.solidariedade_na_mesa.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_basket")
public class BasketEntity {

    @Id
    @Column(name = "basket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BasketId;

    @Column(name = "image")
    private String image;

    @Column(name = "value")
    private Double value;



}
