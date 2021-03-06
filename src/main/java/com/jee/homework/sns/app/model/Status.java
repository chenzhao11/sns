package com.jee.homework.sns.app.model;

import com.jee.homework.sns.common.persistence.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Status extends BaseEntity {
    /**
     * ηΆζε
     */
    @Column(name = "status_name")
    private String statusName;
    public Status(Long id){
        this.setId(id);
    }
}
