document.getElementById("trooper").addEventListener("submit", function(e) {
  e.preventDefault();

  //  let title = {
  //    username: document.getElementById("username").value
  //  };

  //     axios.get("http://localhost:8080/TimeStorm/api/id");
  let username = document.getElementById("username");
  let password = document.getElementById("password");
  let promise = axios.post(
    "http://localhost:8080/TimeStorm/api/id",
    username,
    password
  ); //this is passing on body, remember, its been a while

  promise.then(function(response) {
    console.log("HEJRERER", response.data);
  });
});
