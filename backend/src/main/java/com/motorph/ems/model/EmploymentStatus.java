package com.motorph.ems.model;

import com.motorph.ems.dto.EmploymentStatusDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employment_status")
public class EmploymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private String statusName;

    public EmploymentStatus(String statusName) {
        this.statusName = statusName;
    }

    public EmploymentStatus(int id) {}

    public EmploymentStatusDTO toDTO() {
        return new EmploymentStatusDTO(statusId, statusName);
    }

    public static EmploymentStatus fromDTO(EmploymentStatusDTO statusDTO) {
        return new EmploymentStatus(statusDTO.statusId(), statusDTO.statusName());
    }

    @Override
    public String toString() {
        return "EmploymentStatus{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }

}