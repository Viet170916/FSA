import { AttendancesTable, GroupsTable, SemesterTable } from "../component/AdminTables/GroupsTable.js";
import { GET, POST } from "../RequestHandler/XMLHttpRequest.js";
import { Input } from "../component/Input.js";
import { initCourseSchedule, initSemester } from "../Model/InitValue.js";

const appContainer = document.querySelector( ".app-container" );
const table = appContainer.querySelector( ".main-table .wrap-table" );
const table1 = table.querySelector( ".table-1" );
const table2 = table.querySelector( ".table-2" );
const table3 = table.querySelector( ".table-3" );
const accessLinks = appContainer.querySelector( ".access-links" );
const waiting = `<div class="status is-wait">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                                            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                                        </svg>
                                    </div>
`;
// table
function getSemester(){
  table1.innerHTML = waiting;
  GET( `http://localhost:8080/api/admin/semesters`, function( result ){
    table1.replaceChildren( SemesterTable( result.data,
        function( value = initSemester ){
          table2.innerHTML = "";
          table3.innerHTML = "";
          getGroups( value );
        },
      ),
    );
  } );
}
function getGroups( semester = initSemester ){
  table2.innerHTML = waiting;
  GET( `http://localhost:8080/api/admin/groups?semester=${ semester.id }`,
    function( result ){
      table2.replaceChildren( GroupsTable( result.data,
          function( value = initCourseSchedule ){
            getAttendance( value );
          },
        ),
      );

    },
  );
}
function getAttendance( courseSchedule = initCourseSchedule ){
  table3.innerHTML = waiting;
  GET( `http://localhost:8080/api/admin/slots?semester=${ courseSchedule.group.semester.id }&group=${ courseSchedule.group.code }&course=${ courseSchedule.course.subject.Code }`,
    function( result ){
      console.log( result.data );
      // table3.innerHTML;
      table3.replaceChildren( AttendancesTable( result.data, function(){}, function( buildingName ){
        console.log(buildingName);
        getData( "http://localhost:8080/api/rooms", "", buildingName, function( data ){
          $( ".room-name" ).autocomplete( {
            source: data,
          } );
        } );
      } ) );
      getData( "http://localhost:8080/api/buildings", "", "", function( data ){
        console.log(data);
        $( ".building-name" ).autocomplete( {
          source: data,
        } );
      } );

      // renderForm(result.data);
    } );
}
function getGroup( id = "" ){
  GET( `http://localhost:8080/update/course-schedule?id=${ id }`,
    function( result ){
      detailInfor( result.data );
    } );
}
function sendAddRequest( params = {
  group: null,
  room: null,
  date: null,
  subject: null,
  professor: null,
  slot: null,
} ){
  POST( "http://localhost:8080/update/course-schedule", null, `group=${ params.group }&room=${ params.room }&date=${ params.date }&professor=${ params.professor }&subject=${ params.subject }&slot=${ params.slot }` );
}
function renderForm( courseSchedule = initCourseSchedule ){
  const form = document.querySelector( ".download-area form" );
  form.append( Input( {
      type: "text",
      value: `${ courseSchedule.group.code }`,
      placeholder: "Group",
      name: "group",
    },
    sendAddRequest,
  ) );
  form.append( Input( {
    type: "text",
    value: `${ courseSchedule.room.buildingName + courseSchedule.room.name }`,
    placeholder: "Room",
    name: "room",
    url: `http://localhost:8080/api/room?building=${ "DELTA" }&`,
    search: true,
  }, sendAddRequest ) );
  form.append( Input( {
    type: "date",
    value: `${ courseSchedule.teachingDate }`,
    placeholder: "Teaching Date",
    name: "date",
  }, sendAddRequest ) );
  let subject;
  form.append( Input( {
      type: "text",
      value: `${ courseSchedule.course.subject.Code }`,
      placeholder: "subject",
      name: "subject",
      url: `http://localhost:8080/api/subjects?`,
      search: true,
    },
    sendAddRequest ) );
  function assignProfessor(){
  }
  form.append( Input( {
      type: "text",
      value: `${ courseSchedule.professor?.Code }`,
      placeholder: "professor",
      name: "professor",
      url: `http://localhost:8080/api/professors?department-id=${ null }&`,
      search: true,
    },
    sendAddRequest,
  ) );
  form.append( Input( {
    type: "number",
    value: `${ courseSchedule }`,
    placeholder: "slot",
    name: "slot",
  }, sendAddRequest ) );
  const submit = document.createElement( "button" );
  submit.innerText = "Add schedule of a group";
  submit.onclick = function( event ){
    event.preventDefault();
    const params = document.querySelectorAll( ".textBox" );
    sendAddRequest( {
      group: params[0].value,
      room: params[1].value,
      date: params[2].value,
      subject: params[3].value,
      professor: params[4].value,
      slot: params[5].value,
    } );
  };
  form.append( submit );
}
//
getSemester();
function getData( url, text, dependence, handler = function(){} ){
  GET( `${ url }${text||dependence?"?=":""}${ text?`text=${text}`:"" }${(text&&dependence?"&": "")+dependence ? `&dependence=${ dependence }` : "" }`, function( result ){
    handler( result.data );
  } );
}
function reassign(){
}
// accessLinks.querySelector( ".see-semester" ).onclick = function(){};
// accessLinks.querySelector( ".see-department" ).onclick = function(){};
// accessLinks.querySelector( ".see-notification" ).onclick = function(){};
// accessLinks.querySelector( ".see-exam" ).onclick = function(){};
// accessLinks.querySelector( ".see-history" ).onclick = function(){};
