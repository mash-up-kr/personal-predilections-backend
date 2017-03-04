package kr.co.mash_up.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mash_up.config.SystemPropertiesConfig;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "game_image")
@Getter
@Setter
@NoArgsConstructor
public class GameImage extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @Column
    private String url;

    @Column(length = 255)
    private String fileName;

    @Column(length = 255)
    private String originalFileName;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_image_to_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_image_to_type_id"))
    private GameImageType gameImageType;

    /**
     * 임시 저장할 물리적인 image upload path 제공
     *
     * @return 임시 저장할 image upload path
     */

    public static String getImageUploadTempPath() {
        return String.format("%s/user/tmp", System.getProperty(SystemPropertiesConfig.STORAGE_PATH));
    }

    /**
     * 임시저장된 이미지를 다운받을 수 있는 url 제공
     *
     * @return temporarily image url
     */
    @Transient
    public String getTempImageUrl() {
        return String.format("%s/user/tmp/%s",
                System.getProperty(SystemPropertiesConfig.STORAGE_URI), this.fileName);
    }

    /**
     * 업로드된 이미지를 다운받을 수 있는 url 제공
     *
     * @return image url
     */
    @Transient
    public String getImageUrl() {
        return String.format("%s/user/%d/%s",
                System.getProperty(SystemPropertiesConfig.STORAGE_URI), this.user.getId(), this.fileName);
    }

    /**
     * 물리적인 image upload path 제공
     *
     * @return upload path
     */
    @Transient  // 매핑하지 않는다.
    public String getImageUploadPath() {
        return String.format("%s/user/%d", System.getProperty(SystemPropertiesConfig.STORAGE_PATH), user.getId());
    }

    /**
     * url에서 file name 추출
     *
     * @param imageUrl image url
     * @return file name
     */
    @Transient
    public static String getFileNameFromUrl(String imageUrl) {
        // uri/product/tmp/fileName
        //Todo: confirm url pattern matching??
        return imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
    }

}
