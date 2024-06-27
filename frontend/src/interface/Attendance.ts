
interface AttendanceRes {
  attendanceId: number
  employeeId: number
  date: string
  timeIn: string
  timeOut: string
  totalHours: number
  overtimeHours: number
}

interface AttendanceSummaryRes {
  totalCount: number
  presentCount: number
  lateCount: number
  absentCount: number
  averageTimeIn: string
  averageTimeOut: string
}

interface AttendanceFull {
  attendanceId: number
  employee: EmployeeBasicRes
  date: string
  timeIn: string
  timeOut: string
  totalHours: number
  overtimeHours: number
}
