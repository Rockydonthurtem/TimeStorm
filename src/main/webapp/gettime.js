// document.addEventListener("DOMContentLoaded", function(e) {
//   e.preventDefault();
//   let promise = axios
//     .post("http://localhost:8080/TimeStorm/api/id")
//     //this is passing on body, remember, its been a while
//     .then((res, err) => {
//       console.log("1 Get response in gettime", res);
//     });
// });

let promise = axios
  .post("http://localhost:8080/TimeStorm/id")
  .then((res, err) => {
    console.log("2 Response in gettime", res);
  });

document.getElementById("time");
// .addEventListener("DOMContentLoaded", function() {
e.preventDefault();
let monday = document.getElementById("monday").value;
let tuesday = document.getElementById("tuesday").value;
let wednesday = document.getElementById("wednesday").value;
let thursday = document.getElementById("thursday").value;
let friday = document.getElementById("friday").value;
let saturday = document.getElementById("saturday").value;
let sunday = document.getElementById("sunday").value;
let requestInfo = {
  monday: monday,
  tuesday: tuesday,
  wednesday: wednesday,
  thursday: thursday,
  friday: friday,
  saturday: saturday,
  sunday: sunday
};
// ll
// kk

let promise = axios
  .post("http://localhost:8080/TimeStorm/api/time", requestInfo)
  .then(res => {
    console.log("MY response", res);
  });
console.log("New_timesheet promise", promise);
// fdd
// dsfs
// sdff
// }
// );
