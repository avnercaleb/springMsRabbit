package mscards.entities;

import lombok.Data;
import mscards.entities.enums.CardBrand;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CardBrand cardBrand;
    private BigDecimal income;
    private BigDecimal limit;
}
