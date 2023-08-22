import { initAttendance, initCourseSchedule } from "../Model/InitValue.js";
import { GET } from "../RequestHandler/XMLHttpRequest.js";
import { addDays, format, subDays } from "https://cdn.skypack.dev/date-fns";
import { getMonth, getNextMonth, getPrevMonth, initCalender } from "./calender2.js";

const scheduleTable = document.querySelector( ".schedule-table" );
const months = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];
function renderSchedule( data = [ initCourseSchedule ], currentDate = new Date() ){
  let timeEachSlot = [ "07:30-09:50", "10:00-12:20", "12:50-15:10", "15:20-17:40" ];
  let schedule = [];
  for( let i = 1; i <= 4; i++ ){
    schedule.push( null );
    data.forEach( ( courseSchedule ) => {
      if( courseSchedule.slot === (i + "") ){
        schedule[i - 1] = courseSchedule;
      }
    } );
  }
  document.querySelector( ".second-box .cards-header-date .title" ).innerHTML = currentDate.toDateString();
  scheduleTable.querySelectorAll( "tr" )
  .forEach( ( element, index ) => {
    element.innerHTML =
      `
        <td>
             Slot ${ index + 1 }
            <span class="time">${ timeEachSlot[index] }</span>
        </td>
        <td>
            <a href="${ schedule[index] ? ("http://localhost:8080/" + schedule[index]?.course?.subject?.url) : "#" }">
                ${ schedule[index]? schedule[index]?.course?.subject?.Code : "________" }
            </a>
        </td>
        <td>${ schedule[index] ? (schedule[index]?.room?.buildingName + "-" + schedule[index]?.room?.name) : "________" }</td>
        <td><a href="#">${ schedule[index] ? (schedule[index]?.group?.code):"________"}</a></td>
        
     `;
  } );
}
function scheduleHandler( currentDate ){
  waiting();
  pointInCalender( currentDate );
  GET(
    `http://localhost:8080/api/professor/schedule?date=${ format( currentDate, 'yyyy-MM-dd' ) }`,
    function( result ){
      renderSchedule( result.data?.schedule, currentDate );
    } );
}
function waiting(){
  const timeEachSlot = [ "07:30-09:50", "10:00-12:20", "12:50-15:10", "15:20-17:40" ];
  scheduleTable.querySelectorAll( "tr" )
  .forEach( ( value, index ) => {
    value.innerHTML =
      `
        <td>
             Slot ${ index + 1 }
            <span class="time">${ timeEachSlot[index] }</span>
        </td>
        <td>
            <div class="status is-wait">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                    <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                </svg>
                Loading...
            </div>
        </td>
        
     `;
  } );
}
function pointInCalender( date = new Date()){
  document.querySelectorAll( ".calender tbody .item-2" ).forEach( ( node ) => {
    if( node.innerText === (date.getDate() + "") && document.querySelector( "div.month.cards-header-date .title p.month" )?.innerText === months[date.getMonth()] ){
      node.classList.add( "is-green" );
    }else{
      node.classList.remove( "is-green" );
    }
  } );
}
let currentDate = new Date();
scheduleHandler( currentDate );
function nextDate(){
  currentDate = addDays( currentDate, 1 );
  if( months[currentDate.getMonth()] !== document.querySelector( "div.month.cards-header-date .title p.month" )?.innerText ){
    getNextMonth();
  }
  scheduleHandler( currentDate );
}
function previousDate(){
  currentDate = subDays( currentDate, 1 );
  if( months[currentDate.getMonth()] !== document.querySelector( "div.month.cards-header-date .title p.month" )?.innerText ){
    getPrevMonth();
  }
  scheduleHandler( currentDate );
}
function switchScheduleRelyOnDate(event){
  currentDate = new Date(
    document.querySelector( "div.month.cards-header-date .title p.year" )?.innerText
    +"-"+(months.findIndex((month)=>month === document.querySelector( "div.month.cards-header-date .title p.month" )?.innerText)+1)
    +"-"+event.currentTarget.innerText);
  scheduleHandler(currentDate);
}
function backToCurrentDay(){
  waiting();
  currentDate = new Date();
  initCalender( getMonth( new Date() ) );
  scheduleHandler( currentDate );
}
document.querySelector( ".today" ).onclick = backToCurrentDay;
document.querySelector( ".prev-day" ).onclick = previousDate;
document.querySelector( ".next-day" ).onclick = nextDate;
document.querySelectorAll( ".calender .days .item-2" )
.forEach( (eachNode, index) => {
  eachNode.onclick = switchScheduleRelyOnDate;
} );
