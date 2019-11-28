url = "http://localhost:8080/Timesheet/gettime.html";
document.addEventListener("DOMContentLoaded", function() {
  let promise = axios.post("http://localhost:8080/TimeStorm/api/id"); //this is passing on body, remember, its been a while
});
console.log("in it", url);
document.addEventListener("DOMContentLoaded", function() {
  let promise = axios.get(url).then((res, err) => {
    console.log("Get response", res.data);
  });
});
