package islab1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import islab1.models.auth.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coordinates")
@Getter
@Setter
public class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column(nullable = false)
    private Double x;

    @Column(nullable = false)
    private Long y;
}