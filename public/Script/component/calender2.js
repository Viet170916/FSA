const month = [
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
const weekday = [
  "Sunday",
  "Monday",
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
];
const weekdayShort = [
  "sun",
  "mon",
  "tue",
  "wed",
  "thu",
  "fri",
  "sat",
];
let monthDirection = 0;
export function getNextMonth(){
  document.querySelectorAll( ".calender tbody .item-2" ).forEach( ( node ) => {
      node.classList.remove( "is-green" );
    },
  );
  monthDirection++;
  let current;
  const now = new Date();
  if( now.getMonth() === 11 ){
    current = new Date( now.getFullYear() + monthDirection, 0, 1 );
  }else{
    current = new Date( now.getFullYear(), now.getMonth() + monthDirection, 1 );
  }
  initCalender( getMonth( current ) );
}
export function getPrevMonth(){
  document.querySelectorAll( ".calender tbody .item-2" ).forEach( ( node ) => {
      node.classList.remove( "is-green" );
    },
  );
  monthDirection--;
  let current;
  const now = new Date();
  if( now.getMonth() === 11 ){
    current = new Date( now.getFullYear() + monthDirection, 0, 1 );
  }else{
    current = new Date( now.getFullYear(), now.getMonth() + monthDirection, 1 );
  }
  initCalender( getMonth( current ) );
}
Date.prototype.isSameDateAs = function( pDate ){
  return (
    this.getFullYear() === pDate.getFullYear() &&
    this.getMonth() === pDate.getMonth() &&
    this.getDate() === pDate.getDate()
  );
};
export function getMonth( currentDay ){
  const now = new Date();
  const currentMonth = month[currentDay.getMonth()];
  const monthArr = [];
  for( let i = 1 - currentDay.getDate(); i < 31; i++ ){
    const tomorrow = new Date( currentDay );
    tomorrow.setDate( currentDay.getDate() + i );
    if( currentMonth !== month[tomorrow.getMonth()] ){
      break;
    }else{
      monthArr.push( {
        date: {
          weekday: weekday[tomorrow.getDay()],
          weekday_short: weekdayShort[tomorrow.getDay()],
          day: tomorrow.getDate(),
          month: month[tomorrow.getMonth()],
          year: tomorrow.getFullYear(),
          current_day: !!now.isSameDateAs( tomorrow ),
          date_info: tomorrow,
        },
      } );
    }
  }
  return monthArr;
}
let clickCounter = 0;
function clearCalender(){
  $( ".calender table tbody tr" ).each( function(){
    $( this ).find( "td" ).removeClass( "active selectable currentDay between hover" ).html( "" );
  } );
  $( ".calender td" ).each( function(){
    $( this ).unbind( 'mouseenter' ).unbind( 'mouseleave' );
  } );
  $( ".calender td" ).each( function(){
    $( this ).unbind( 'click' );
  } );
  clickCounter = 0;
}
export function initCalender( monthData ){
  let row = 0;
  let classToAdd = "";
  let currentDay = "";
  const today = new Date();
  clearCalender();
  $.each( monthData,
    function( i, value ){
      let weekday = value.date.weekday_short;
      let day = value.date.day;
      let column = 0;
      $( ".left-wrapper .cards-header p.month" ).html( value.date.month );
      $( ".left-wrapper .cards-header p.year" ).html( value.date.year );
      if( value.date.current_day ){
        currentDay = "currentDay";
        classToAdd = "selectable";
        $( ".right-wrapper .cards-header span" ).html( value.date.weekday );
        $( ".right-wrapper .day" ).html( value.date.day );
        $( ".right-wrapper .month" ).html( value.date.month );
      }
      if( today.getTime() < value.date.date_info.getTime() ){
        classToAdd = "selectable";
      }
      $( "tr.weedays th" ).each( function(){
        let row = $( this );
        if( row.data( "weekday" ) === weekday ){
          column = row.data( "column" );
        }
      } );
      $( $( $( $( "tr.days" ).get( row ) ).find( "td" ).get( column ) ).addClass( classToAdd + " " + currentDay ).html( day ) );
      currentDay = "";
      if( column === 6 ){
        row++;
      }
    } );
  $( "td.selectable" ).click( function(){
    // dateClickHandler($(this));
  } );
}
initCalender( getMonth( new Date() ) );
$( ".fa-angle-double-right" ).click( function(){
  $( ".right-wrapper" ).toggleClass( "is-active" );
  $( this ).toggleClass( "is-active" );
} );
$( ".fa-angle-left" ).click( function(){
  getPrevMonth();
  $( ".content-wrapper" ).addClass( "is-rotated-left" );
  setTimeout( function(){
    $( ".content-wrapper" ).removeClass( "is-rotated-left" );
  }, 195 );
} );
$( ".fa-angle-right" ).click( function(){
  getNextMonth();
  $( ".content-wrapper" ).addClass( "is-rotated-right" );
  setTimeout( function(){
    $( ".content-wrapper" ).removeClass( "is-rotated-right" );
  }, 195 );
} );

