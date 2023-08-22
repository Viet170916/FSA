import { GET } from "../RequestHandler/XMLHttpRequest.js";
const printContent = function( data = {
  code: "",
  firstName: "",
  lastName: "",
  gender: "",
  email: "",
  birthdate: "",
  phone:"",
  address:"",
  image:"",
} ){
  document.querySelector( "p.name" ).innerHTML = (data?.firstName ? data?.firstName : "") + " " + (data?.lastName ? data?.lastName : "");
  document.querySelector( "p.student-code" ).innerHTML = data?.code ? data?.code : "";
  document.querySelector( "p.gender" ).innerHTML = data?.gender ? (data?.gender===1?"Male":"Female" ): "";
  document.querySelector( "p.email" ).innerHTML = data?.email ? data?.email : "";
  document.querySelector( "p.birth-date" ).innerHTML = data?.birthdate ? data?.birthdate : "";
  document.querySelector( "p.address" ).innerHTML = data?.address ? data?.address : "";
  document.querySelector( "p.phone" ).innerHTML = data?.phone ? data?.phone : "";


}
GET("http://localhost:8080/api/user/profile", function( result ){
  console.log(result.data);
  printContent(result.data);
})


