package br.com.backend.solidariedade_na_mesa.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_donation")
public class DonationEntity {

    @Id
    @Column(name = "donation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DonationId;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "donation_date")
    private LocalDateTime donationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "id.donation", cascade = CascadeType.ALL)
    private List<DonationItemEntity> items;



}
