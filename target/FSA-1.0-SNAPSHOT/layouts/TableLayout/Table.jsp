<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/Fantastic.css">
    <link rel="stylesheet" href="css/Table.css"/>
    <style>
        a{
            padding: 5px;
            background-color: #34495E;
            margin: 10px;
            border-radius: 0.2rem;
            color: #dddd55 !important;
        }
    </style>
</head>
<body>
<section id="cursor-1" class="container container-cursor-1">
    <table class="rwd-table main-table"></table>
    <div class="controller"></div>
</section>
<footer>
    <span class="curzr-hover btn btn-previous">
  </span> <span class="curzr-hover btn btn-next">
  </span>
</footer>
<div class="curzr-arrow-pointer" hidden>
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32">
        <path class="inner" d="M25,30a5.82,5.82,0,0,1-1.09-.17l-.2-.07-7.36-3.48a.72.72,0,0,0-.35-.08.78.78,0,0,0-.33.07L8.24,29.54a.66.66,0,0,1-.2.06,5.17,5.17,0,0,1-1,.15,3.6,3.6,0,0,1-3.29-5L12.68,4.2a3.59,3.59,0,0,1,6.58,0l9,20.74A3.6,3.6,0,0,1,25,30Z" fill="#F2F5F8"></path>
        <path class="outer" d="M16,3A2.59,2.59,0,0,1,18.34,4.6l9,20.74A2.59,2.59,0,0,1,25,29a5.42,5.42,0,0,1-.86-.15l-7.37-3.48a1.84,1.84,0,0,0-.77-.17,1.69,1.69,0,0,0-.73.16l-7.4,3.31a5.89,5.89,0,0,1-.79.12,2.59,2.59,0,0,1-2.37-3.62L13.6,4.6A2.58,2.58,0,0,1,16,3m0-2h0A4.58,4.58,0,0,0,11.76,3.8L2.84,24.33A4.58,4.58,0,0,0,7,30.75a6.08,6.08,0,0,0,1.21-.17,1.87,1.87,0,0,0,.4-.13L16,27.18l7.29,3.44a1.64,1.64,0,0,0,.39.14A6.37,6.37,0,0,0,25,31a4.59,4.59,0,0,0,4.21-6.41l-9-20.75A4.62,4.62,0,0,0,16,1Z" fill="#111920"></path>
    </svg>
</div>
<script src="component/Fantastic.js"></script>
<script src="component/Table.js"></script>
<script>
  const renderATag = ( url = [] ) => {
    url.forEach( ( value ) => {
      const ATag = document.createElement( "a" );
      ATag.href = value.url;
      ATag.innerHTML = value.name;
      document.querySelector( ".controller" ).append( ATag );
    } )
  }
  const toSentenceCase = camelCase => {
    if( camelCase ){
      let result = camelCase.replace( /([A-Z])/g, ' $1' );
      result = result[0].toUpperCase() + result.substring( 1 ).toLowerCase();
      if( result.includes( "i d" ) ){
        return result.replace( "i d", "ID" );
      }
      return result;
    }
    return '';
  };
  function Table( parentElement, list ){
    try{
      const row = document.createElement( "tr" );
      for( let listElementKey in list[0] ){
        const colum = document.createElement( "th" );
        colum.innerHTML = toSentenceCase( listElementKey );
        row.append( colum );
        parentElement.append( row );
      }
    }catch{
      console.log( "no data found!" );
      return;
    }
    list.forEach( ( value ) => {
      const row = document.createElement( "tr" );
      for( let attribute in value ){
        const colum = document.createElement( "td" );
        colum.innerHTML = value[attribute];
        row.append( colum )
      }
      parentElement.append( row );
    } )
  }
  renderATag( <%=request.getAttribute("urlForATag")%> );
  Table( document.querySelector( '.main-table' ), <%=request.getAttribute("data")%> );
</script>
</body>
</html>
