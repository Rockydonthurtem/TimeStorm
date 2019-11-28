timesheet = "http://localhost:8080/TimeStorm/gettime.html";
document.addEventListener("DOMContentLoaded", function(e) {
  e.preventDefault();
  let promise = axios.post("http://localhost:8080/TimeStorm/api/id"); //this is passing on body, remember, its been a while
});

document.addEventListener("DOMContentLoaded", function() {
  let promise = axios.get(timesheet).then((res, err) => {
    console.log("Get response", res.data);
  });
});

new_timesheet = "http://localhost:8080/TimeStorm/api/id";
document
  .getElementById("button")
  .addEventListener("DOMContentLoaded", function() {
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
    console.log("New_timesheet");
    let promise = axios.post(new_timesheet, requestInfo);
    console.log("New_timesheet promise", promise);
  });
