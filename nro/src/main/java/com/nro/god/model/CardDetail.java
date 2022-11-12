package com.nro.god.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "card_detail")
public class CardDetail implements Serializable {
    private static final long serialVersionUID = 7327493400777577500L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_detail_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Card card;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "thoi_vang", nullable = false)
    private Integer thoiVang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getThoiVang() {
        return thoiVang;
    }

    public void setThoiVang(Integer thoiVang) {
        this.thoiVang = thoiVang;
    }

}