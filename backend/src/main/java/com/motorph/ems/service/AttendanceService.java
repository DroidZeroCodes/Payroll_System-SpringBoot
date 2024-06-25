package com.motorph.ems.service;

import com.motorph.ems.dto.AttendanceDTO;
import com.motorph.ems.dto.AttendanceSummaryDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface AttendanceService {
     AttendanceDTO addNewAttendance(AttendanceDTO attendance);

     List<AttendanceDTO> getAllAttendances();

     List<AttendanceDTO> getAllByEmployeeId(Long employeeId);

     Optional<AttendanceDTO> getAttendanceById(Long attendanceId);

     Optional<AttendanceDTO> getAttendanceByEmployeeIdAndDate(Long employeeId, LocalDate date);

     List<AttendanceDTO> getAllByDate(LocalDate date);

     List<AttendanceDTO> getAttendancesForDateRange(LocalDate start, LocalDate end);

     List<AttendanceDTO> getAttendancesAfterTimeIn(LocalTime timeIn, LocalDate date);

    public AttendanceSummaryDTO getAttendanceSummaryByEmployeeId(Long employeeId);

     List<AttendanceDTO> getAttendancesAfterTimeOut(LocalTime timeOut, LocalDate date);

     AttendanceDTO updateAttendance(Long attendanceId, AttendanceDTO attendance);

     void deleteAttendanceById(Long attendanceId);

    List<AttendanceDTO> getAllAttendanceByEmployeeIdAndDateRange(Long id, LocalDate start, LocalDate end);
}
