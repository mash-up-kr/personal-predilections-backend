package kr.co.mash_up.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_history_to_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_history_to_game_id"))
    private Game game;

    @Column
    private boolean promoter;

    @Column
    private Double matchingRatio = 0.0;

    @Column
    private Long weightSum = 0L;

    public History(User user, Game game, boolean promoter) {
        this.user = user;
        this.game = game;
        this.promoter = promoter;
    }

    public void addWeight(Long weight) {
        this.weightSum += weight;
        this.matchingRatio = (weightSum.doubleValue() * 100) / 105;
    }
}
