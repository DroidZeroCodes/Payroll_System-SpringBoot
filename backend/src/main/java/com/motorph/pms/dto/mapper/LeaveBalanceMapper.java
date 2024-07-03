package com.motorph.ems.dto.mapper;

import com.motorph.ems.dto.LeaveBalanceDTO;
import com.motorph.ems.dto.LeaveTypeDTO;
import com.motorph.ems.model.LeaveBalance;
import com.motorph.ems.model.LeaveBalance.LeaveType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeaveBalanceMapper {

    public LeaveBalanceDTO toDTO(LeaveBalance leaveBalance) {
        if (leaveBalance == null) {
            return null;
        }

        return LeaveBalanceDTO.builder()
                .id(leaveBalance.getLeaveBalanceId())
                .employeeId(leaveBalance.getEmployee().getEmployeeId())
                .leaveTypeId(leaveBalance.getLeaveType().getLeaveTypeId())
                .balance(leaveBalance.getBalance())
                .build();
    }

    public List<LeaveBalanceDTO> toDTO(List<LeaveBalance> leaveBalances) {
        if (leaveBalances == null) {
            return null;
        }

        return leaveBalances.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LeaveBalance toEntity(LeaveBalanceDTO leaveBalanceDTO) {
        if (leaveBalanceDTO == null || leaveBalanceDTO.employeeId() == null) {
            throw new IllegalArgumentException("Employee ID cannot be null when creating leave balance");
        }

        return new LeaveBalance(
                leaveBalanceDTO.employeeId(),
                leaveBalanceDTO.leaveTypeId(),
                leaveBalanceDTO.balance()
        );
    }

    public List<LeaveBalance> toEntity(List<LeaveBalanceDTO> leaveBalanceDTOS) {
        if (leaveBalanceDTOS == null) {
            return null;
        }

        return leaveBalanceDTOS.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public void updateEntity(LeaveBalanceDTO leaveBalanceDTO, LeaveBalance leaveBalance) {
        if (leaveBalanceDTO == null || leaveBalanceDTO.employeeId() == null) {
            throw new IllegalArgumentException("Employee ID cannot be null when updating leave balance");
        }

        if (!leaveBalance.getEmployee().getEmployeeId().equals(leaveBalanceDTO.employeeId())) {
            throw new IllegalArgumentException("Employee ID does not match when updating leave balance");
        }

        leaveBalance.setBalance(leaveBalanceDTO.balance());
    }

    public LeaveTypeDTO toLeaveTypeDTO(LeaveType leaveType) {
        if (leaveType == null) {
            return null;
        }

        return LeaveTypeDTO.builder()
                .id(leaveType.getLeaveTypeId())
                .typeName(leaveType.getType())
                .build();
    }

    public List<LeaveTypeDTO> toLeaveTypeDTO(List<LeaveType> leaveBalances) {
        if (leaveBalances == null) {
            return null;
        }

        return leaveBalances.stream()
                .map(this::toLeaveTypeDTO)
                .collect(Collectors.toList());
    }

    public LeaveType toLeaveTypeEntity(LeaveTypeDTO leaveTypeDTO) {
        return new LeaveType(leaveTypeDTO.typeName());
    }
}