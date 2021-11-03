package com.ajrt.carlostransportes.entities;

import com.ajrt.carlostransportes.dtos.FeedbackDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column
    private Integer avaliation;

    @Column
    private String description;

    public Feedback(FeedbackDTO feedbackDTO) {
        this.id = feedbackDTO.getId();
        this.avaliation = feedbackDTO.getAvaliation();
        this.description = feedbackDTO.getDescription();
    }
}
