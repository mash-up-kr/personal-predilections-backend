package kr.co.mash_up.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@MappedSuperclass
@JsonInclude(value = JsonInclude.Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility =
        JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class AbstractEntity<K extends Serializable> implements Serializable {

    /**
     * 생성일자
     */
    @Column(name = "created_at", insertable = true, updatable = false)
    protected LocalDateTime createdAt;

    /**
     * 수정일자
     */
    @Column(name = "updated_at", insertable = true, updatable = true)
    protected LocalDateTime updatedAt;

    @PrePersist
    private void onPersist(){
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public long getCreatedTimestamp(){
        if(this.createdAt == null){
            return 0;
        }
        return Timestamp.valueOf(this.createdAt).getTime();
    }

    public long getUpdatedTimestamp(){
        if(this.updatedAt == null){
            return 0;
        }
        return Timestamp.valueOf(this.updatedAt).getTime();
    }
}
