const renderATag = (url=[])=>{
  url.forEach((value)=>{
    const ATag = document.createElement("a");
    ATag.href = value.url;
    ATag.innerHTML = value.name;
    document.querySelector(".controller").append(ATag);
  })
}
const toSentenceCase = camelCase => {
  if( camelCase ){
    let result = camelCase.replace( /([A-Z])/g, ' $1' );
    result = result[0].toUpperCase() + result.substring( 1 ).toLowerCase();
    if( result.includes("i d") ){
      return result.replace("i d", "ID");
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
