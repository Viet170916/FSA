export function
GET(
  url = "",
  responseHandler = function( result = { data: {} } ){},
  waiting  = function(  ){}
){
  const http = new XMLHttpRequest();
  http.open( 'GET', url, true );
  http.send();
  http.onreadystatechange = function(){
    if( this.readyState !==4 ){
      console.log("loading");
      waiting();
    }
    if( this.readyState === 4 ){
      responseHandler( { data: JSON.parse( this.responseText ) } );
    }
  };
}

export function POST(url, responseHandler = function(  ){}, params="param1=value1&param2=value2"){
  const http = new XMLHttpRequest();
  http.open( 'POST', url, true );
  http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  http.onreadystatechange = function() {
    if (http.readyState === 4 && http.status === 200) {

      console.log(http.responseText);
      responseHandler();
    }
  };

  http.send(params);
}
export function sendPost(url, Data, callback= function(  ){}) {
  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status >= 200 && xhr.status < 300) {
        // Request thành công
        const response = JSON.parse(xhr.responseText);
        callback(response);
      } else {
        // Xảy ra lỗi
        const response = JSON.parse(xhr.responseText);
        console.log("error");
        console.log(response);
        callback(response);
      }
    }
  };

  xhr.open('POST', url, true);
  xhr.setRequestHeader('Content-Type', 'application/json'); // Thiết lập tiêu đề cho request

  // Gửi request với dữ liệu là chuỗi JSON
  xhr.send(JSON.stringify(Data));
}

