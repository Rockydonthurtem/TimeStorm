document.getElementById("trooper").addEventListener("submit", function(e) {
  e.preventDefault();

  let title = {
    name: document.getElementById("first").value
  };

  //   axios.get("http://localhost:8080/TimeStorm/api/id");
  let id = document.getElementById("first").value;
  let promise = axios.get(`http://localhost:8080/TimeStorm/api?id=${id}`);

  promise.then(function(response) {
    console.log("HEJRERER", response.data);
  });
});
