import { initCourseSchedule, initDepartment, initSemester } from "../../Model/InitValue.js";
import { format } from "https://cdn.skypack.dev/date-fns";
import { sendPost } from "../../RequestHandler/XMLHttpRequest.js";

function row( data = [], onClick = function( data = [] ){}, id, className = "" ){
  const groupRow = document.createElement( "div" );
  groupRow.className = "files-table-row";
  groupRow.innerHTML =
    `
  ${ (data.map( ( value ) => {
      return `<div class="table-cell ${ className }">${ value } </div>`;
    } ).join( "" )) } 

  `;
  groupRow.onclick = function( event ){
    this.parentNode.querySelectorAll( ".files-table-row" ).forEach( ( row ) => {
      row.querySelector( ".upload-button" )?.classList?.remove( "show-button" );
      row.classList.remove( "row-is-green" );
    } );
    this.classList.add( "row-is-green" );
    onClick( id );
  };
  return groupRow;
}
export function GroupsTable( data = [ initCourseSchedule ], onClick ){
  const filesTable = document.createElement( "div" );
  filesTable.className = "files-table";
  const tableHeader = document.createElement( "div" );
  tableHeader.className = "files-table-header";
  tableHeader.innerHTML = `
    <div class="column-header table-cell">Name</div>
    <div class="column-header table-cell">Course</div>
<!--     <div class="column-header table-cell size-cell">Semester</div> -->
  `;
  filesTable.append( tableHeader );
  data.forEach( ( courseSchedule, index ) => {
      filesTable.append( row(
          [
            courseSchedule.group.code,
            courseSchedule.course.subject.Code,
            // courseSchedule.group.semester.name,
          ],
          onClick,
          courseSchedule,
        ),
      );
    },
  );
  return filesTable;
}
export function SemesterTable( data = [ initSemester ], onClick = function(){} ){
  const filesTable = document.createElement( "div" );
  filesTable.className = "files-table";
  const tableHeader = document.createElement( "div" );
  tableHeader.className = "files-table-header";
  tableHeader.innerHTML = `
    <div class="column-header table-cell">Name</div>
    <div class="column-header table-cell">Start date</div>
<!--     <div class="column-header table-cell">End date</div> -->
  `;
  filesTable.append( tableHeader );
  data.forEach( ( semester, index ) => {
      filesTable.append( row( [
          semester.name,
          semester.startDate,
          semester.endDate,
        ], onClick, semester ),
      );
    },
  );
  return filesTable;
}
export function DepartmentTable( data = [ initDepartment ], onClick = function(){} ){
  const filesTable = document.createElement( "div" );
  filesTable.className = "files-table";
  const tableHeader = document.createElement( "div" );
  tableHeader.className = "files-table-header";
  tableHeader.innerHTML = `
    <div class="column-header table-cell">Name</div>
  `;
  filesTable.append( tableHeader );
  data.forEach( ( department, index ) => {
      filesTable.append( row( [
        department.name,
      ], onClick, department.id ) );
    },
  );
  return filesTable;
}
export function AttendancesTable( data = [ {} ], onClick, onChange ){
  const filesTable = document.createElement( "div" );
  filesTable.className = "files-table";
  const tableHeader = document.createElement( "div" );
  tableHeader.className = "files-table-header";
  tableHeader.innerHTML = `
    <div class="column-header table-cell">Slot</div>
    <div class="column-header table-cell">Building</div>
    <div class="column-header table-cell">Room</div>
    <div class="column-header table-cell">Teaching Date</div>
  `;
  filesTable.append( tableHeader );
  data.forEach( ( courseSchedule, index ) => {
      courseSchedule?.teachingDate < format( new Date(), "yyyy-MM-dd" ) ?
        filesTable.append( row(
          [
            courseSchedule?.slot,
            courseSchedule?.room?.buildingName,
            courseSchedule?.room?.name,
            courseSchedule?.teachingDate,
          ], onClick, courseSchedule.id, "is-blur",
        ) )
        :
        filesTable.append( editableRow(
            {
              slot: {
                value: courseSchedule?.slot,
                className: "slot",
                type: "number",
              },
              buildingName: {
                value: courseSchedule?.room?.buildingName,
                className: "building-name",
                type: "text",
              },
              roomName: {
                value: courseSchedule?.room?.name,
                className: "room-name",
                type: "text",
              },
              teachingDate: {
                value: courseSchedule?.teachingDate,
                className: "teaching-date",
                type: "date",
              },
            },
            onClick,
            courseSchedule.id,
            (data) => {
              console.log("1: "+data.buildingName);
              onChange( data.buildingName );
              },
            {
              isHaveSubmit: true,
              submitHandler( data =
                               {
                                 slot: "",
                                 buildingName: "",
                                 roomName: "",
                                 teachingDate: "",
                               } ){
                data.slot? courseSchedule.slot =data.slot:null;
                data.buildingName? courseSchedule.room.buildingName = data.buildingName:null;
                data.roomName?courseSchedule.room.name = data.roomName:null;
                data.teachingDate?courseSchedule.teachingDate = data.teachingDate:null;
                sendPost( "http://localhost:8080/update/schedule", courseSchedule, function( result ){
                  console.log(result?.error);
                  const message = document.querySelector(".show-message");
                  message.innerText=result.mess||result?.error;
                   if( result.error ){
                     console.log("iss-redd");
                    message.classList.remove("is-green");
                    message.classList.add("is-red");
                  }else{
                    message.classList.remove("is-red");
                    message.classList.add("is-green");
                  }

                  setTimeout(()=>{document.querySelector("p.show-message").innerText=""},3000 );
                });
              },
            },
          ),
        );
      // filesTable.append( groupRow );
    },
  );
  return filesTable;
}
const initElementProps = {
  type: "",
  value: "",
  className: "",
};
function editableRow(
  data = {
    slot: initElementProps,
    buildingName: initElementProps,
    roomName: initElementProps,
    teachingDate: initElementProps,
  },
  onClick = function(){},
  id,
  onChange = function(){},
  submit = {
    isHaveSubmit: false,
    submitHandler: function(){},
  },
){
  const groupRow = document.createElement( "div" );
  groupRow.className = "files-table-row";
  let dataToSend =
    {
      slot: null,
      buildingName: null,
      roomName: null,
      teachingDate: null,
    };
  for( let key in data ){
    const tableCell = document.createElement( "div" );
    tableCell.className = "table-cell";
    const input = document.createElement( "input" );
    input.className = data[key]?.className;
    input.value = data[key]?.value;
    input.type = data[key]?.type;
    input.name = key;
    input.onblur = ( event ) => {

      dataToSend[key] = event.currentTarget.value;
      console.log(event.currentTarget.value);
    };
    key === "roomName" ? input.onfocus = ()=>{onChange(dataToSend)}: null;
    tableCell.append( input );
    groupRow.append( tableCell );
  }
  if( submit.isHaveSubmit ){
    const submitButton = document.createElement( "button" );
    submitButton.innerHTML = `<ion-icon name="arrow-up"></ion-icon>`;
    submitButton.onclick = () => {
      submit.submitHandler( dataToSend );
    };
    submitButton.classList.add( "upload-button" );
    groupRow.append( submitButton );
  }
  // groupRow.onclick = () => {onClick( id );};
  groupRow.onclick = function( event ){
    this.parentNode.querySelectorAll( ".files-table-row" ).forEach(
      ( row ) => {
        row.querySelector( ".upload-button" )?.classList?.remove( "show-button" );
        row.classList.remove( "row-is-green" );
      } );
    this.classList.add( "row-is-green" );
    this.querySelector( ".upload-button" )?.classList?.add( "show-button" );
    onClick( id );
  };
  return groupRow;
}
