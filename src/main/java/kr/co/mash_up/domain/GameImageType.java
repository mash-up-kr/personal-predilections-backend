package kr.co.mash_up.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game_image_type")
@Getter
@Setter
@NoArgsConstructor
public class GameImageType extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Long weight;

    @OneToMany(mappedBy = "gameImageType")
    private List<GameImage> gameImages;

}
