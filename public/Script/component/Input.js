import { GET } from "../RequestHandler/XMLHttpRequest.js";
import { format } from "https://cdn.skypack.dev/date-fns";

export function Input( props = {
  type: "",
  value: "",
  placeholder: "",
  name: "",
  url: "",
  search: false,
}, getValue = function(){} ){
  const div = document.createElement( "div" );
  const form = document.createElement( "div" );
  const label = document.createElement( "label" );
  const input = document.createElement( "input" );
  const ul = document.createElement( "ul" );
  ul.className = "search-text";
  input.name = props.name;
  input.type = props.type;
  input.placeholder = props.placeholder;
  input.className = "textBox form__input";
  input.value = props.value;
  input.onchange = function( event ){
    input.value = event.target.value;
    if( props.type === "date" ){
      if( event.target.value < format( new Date(), "yyyy-MM-dd" ) ){
        // this.value = format( new Date(), "yyyy-MM-dd" );
        const li = document.createElement( "li" );
        // li.style = { color: "red" };

        li.append( "please set update the time in the future" );
        ul.append( li );
        div.append(ul);
      }
    }
  };
  input.onblur = function( event ){
    if( props.type === "number" ){
      if( Number.parseInt( input.value ) > 4 ){
        input.value = "4";
      }else if( Number.parseInt( input.value ) < 1 ){
        input.value = "1";
      }
    }
  };
  if( props.search ){
    input.oninput = function( event ){
      document.querySelector( ".search-text" )?.innerHTML ?
        document.querySelector( ".search-text" ).innerHTML = "" : function(){};
      getData( event.currentTarget.value );
    };
  }
  let isMouseUpInsideElement = false;
  document.addEventListener( "mouseup", function(){
    if( isMouseUpInsideElement ){
      document.querySelector( ".search-text" ).innerHTML = "";
      isMouseUpInsideElement = true;
    }
  } );
  ul.addEventListener( "mouseleave", function(){
    isMouseUpInsideElement = true;
  } );
  ul.addEventListener( "mousedown", function(){
    isMouseUpInsideElement = false;
  } );
  label.append( input );
  form.append( label );
  div.append( props.placeholder );
  div.append( form );
  function getData( code ){
    GET( `${ props.url }code=${ code }`, function( result ){
      result.data.forEach( ( value ) => {
        const li = document.createElement( "li" );
        li.innerText = value.code ? value.code : (value.Code ? value.Code : value.name);
        li.addEventListener( 'click', function(){
          document.getElementsByName( props.name )[0].value = this.innerText;
          document.querySelector( ".search-text" ).innerHTML = "";
        } );
        ul.append( li );
      } );
      div.append( ul );
    } );
  }
  return div;
}

