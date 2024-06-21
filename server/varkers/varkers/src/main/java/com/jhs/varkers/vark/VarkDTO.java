package com.jhs.varkers.vark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VarkDTO {
    private Long id;
    private Long accountId;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
