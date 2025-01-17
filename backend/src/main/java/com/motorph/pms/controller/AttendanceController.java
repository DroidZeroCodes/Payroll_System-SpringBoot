package com.motorph.pms.controller;

import com.motorph.pms.dto.AttendanceDTO;
import com.motorph.pms.model.Attendance;
import com.motorph.pms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping()
    public ResponseEntity<List<AttendanceDTO>> getAttendances(
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "id", required = false) Long id
    ) {

        List<AttendanceDTO> attendances;
        if(date != null){
            if(id != null && !id.equals(0L)){
                attendances = attendanceService.getAllByEmployeeId(id);
            } else {
                attendances = attendanceService.getAllByDate(LocalDate.parse(date));
            }
        } else {
            attendances = attendanceService.getAllAttendances();
        }

        return ResponseEntity.ok(attendances);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(
            @PathVariable(value = "id") Long attendanceId,
            @RequestBody AttendanceDTO attendance
    ) {
        AttendanceDTO updatedAttendance = attendanceService.updateAttendance(attendanceId, attendance);

        return ResponseEntity.ok(updatedAttendance);
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> addAttendance(@RequestBody Attendance attendance) {
        AttendanceDTO attendanceDTO = attendanceService.addNewAttendance(attendance);

        return ResponseEntity.ok(attendanceDTO);
    }
}
