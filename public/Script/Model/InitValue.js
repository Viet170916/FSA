export const initDepartment = {
  "id": "",
  "name": "",
};
export const initSubject = {
  url: "",
  "id": "",
  "Code": "",
  "Name": "",
  "department": initDepartment,
};
export const initCourse = {
  "url": "",
  "code": "",
  "subject": initSubject,
};
export const initProfessor = {
  "url": "",
  "id": "",
  "image": "",
  "firstName": "",
  "lastName": "",
  "gender": "",
  "email": "",
  "birthdate": "",
};
export const initSemester = {
  id:null,
  "name": "",
  "startDate": "",
  "endDate": "",
};
export const initRoom = {
  "id": "",
  "name": "",
  "buildingName": "",
};
export const initGroup = {
  "url": null,
  "id": null,
  code: null,
  semester: initSemester,
};
export const initCourseSchedule = {
  id:null,
  "course": initCourse,
  "professor": initProfessor,
  "group": initGroup,
  "room": initRoom,
  "teachingDate": "",
};
export const initSlot = {
  Id: null,
  "slot": null,
  "courseSchedule": initCourseSchedule,
};
export const initAttendance = {
  "id": "",
  "studentURL": "",
  "isAbsent": "false",
  "semester": initSemester,
  slot: initSlot,
};
