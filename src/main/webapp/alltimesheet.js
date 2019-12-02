// document
//   .getElementById("time")
//   .addEventListener("DOMContentLoaded", function(e) {
//     let promise = axios
//       .get("http://localhost:8080/TimeStorm/api/all")
//       .then(res => {
//         console.log("MY response", res);
//       });
//     console.log("All time promise", promise);
//   });
// .addEventListener("DOMContentLoaded", function() {
document.addEventListener("DOMContentLoaded", function() {
  let promise = axios
    .get("http://localhost:8080/TimeStorm/api/all")
    .then(res => {
      console.log("ALL sheets ", res);
      all(res.data);
    });
});

// alltable apparent doesnt want to shoe
// grab data when the window loads
// CB func on window object
// when the window loads, load the res data
window.load = () => {
  load(all);
};

function all(all) {
  // made a function to input content
  console.log("ALL FUNC", all);
  const allTable = document.getElementById("allTable");

  let incomingData = ""; /*this will append html and then inject in 8:00*/
  //   append incoming data as a string and then hopefully put it in allTable XX

  //  contcat to the string the data I want
  incomingData += ` <thead>

</thead>
  <tr>
     <th>Monday</th>
    <th>Tuesday</th>
    <th>Wednesday</th>
    <th>Thursday</th>
    <th>Friday</th>
    <th>Saturday</th>
    <th>Sunday</th>
    <th>Status</th>
</tr>
<tr>
  <td>${all.monday}</td>
  <td> ${all.tuesday}</td>
  <td>${all.wednesday}</td>
  <td>${all.thursday}</td>
  <td>${all.friday}</td>
  <td>${all.saturday}</td>
  <td>${all.sunday}</td>
  <td>${all.status}</td>
  </tr>`;
  //   }
  console.log("Table body log", allTable);
  allTable.innerHTML = incomingData;
}

// let monday = document.getElementById("monday").value;
// let tuesday = document.getElementById("tuesday").value;
// let wednesday = document.getElementById("wednesday").value;
// let thursday = document.getElementById("thursday").value;
// let friday = document.getElementById("friday").value;
// let saturday = document.getElementById("saturday").value;
// let sunday = document.getElementById("sunday").value;
// let requestInfo = {
//   monday: monday,
//   tuesday: tuesday,
//   wednesday: wednesday,
//   thursday: thursday,
//   friday: friday,
//   saturday: saturday,
//   sunday: sunday
// };
// ll
// kk

// let promise = axios
//   .post("http://localhost:8080/TimeStorm/api/all", requestInfo)
//   .then(res => {
//     console.log("MY response", res);
//   });
// console.log("New_timesheet promise", promise);
