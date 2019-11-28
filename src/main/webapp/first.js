document.getElementById("trooper").addEventListener("submit", function(e) {
  e.preventDefault();

  //  let title = {
  //    username: document.getElementById("username").value
  //  };

  //     axios.get("http://localhost:8080/TimeStorm/api/id");
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  console.log("username", username);
  console.log("password", password);
  let requestInfo = {
    username: username,
    password: password
  };
  let promise = axios.get(
    /*CHANGE THIS BACK TO POST OR HANDLE IN FC W/ DIFF VERB */
    "http://localhost:8080/TimeStorm/api/id",
    requestInfo
  );
  //this is passing on body, remember, its been a while
  console.log("PROMISE", promise);
});
