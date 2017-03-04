package kr.co.mash_up.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<GameImage> gameImages;

    @OneToMany(mappedBy = "user")
    private List<History> histories;

    public enum Gender {
        MALE,
        FEMALE
    }
}
