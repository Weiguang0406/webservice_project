const HOST = "http://localhost:8090";

const addStudent = () => {
  const studentNo = document.getElementById("studentNum").value;
  const firstName = document.getElementById("firstname").value;
  const lastName = document.getElementById("lastname").value;
  const address = document.getElementById("address").value;
  const isActive = document.getElementById("isactive").value;
  console.log(studentNo);
  $.ajax({
    method: "post",
    url: `${HOST}/students`,
    data: JSON.stringify({
      studentNo: studentNo,
      fName: firstName,
      lName: lastName,
      address: address,
      active: isActive,
    }),
    headers: {
      Accept: "application/json",
      "Content-type": "application/json",
    },
  })
    .done((response) => alert(response))
    .fail((obj, textStatus) => {
      if (obj && obj.responseText) {
        alert(obj.responseText);
      }
    });
};

const getAllStudentsFromDb = () => {
  $.ajax({
    method: "get",
    url: `${HOST}/students`,
  })
    .done((response) => {
      document.getElementById("resulttable").innerHTML =
        "<tr><th>studentNum</th><th>First name</th><th>Last name</th><th>Address</th><th>Active</th></tr>";
      console.log(response);
      for (const obj of response) {
        // if (response.length() % 6 === 0) {
        //   document.getElementById("resulttable").innerHTML += "<tr>";
        // } else {
        document.getElementById("resulttable").innerHTML +=
          "<tr>" +
          // "<th>" +
          // obj.id +
          // "</th>" +
          "<th>" +
          obj.studentNo +
          "</th>" +
          "<th>" +
          obj.fName +
          "</th>" +
          "<th>" +
          obj.lName +
          "</th>" +
          "<th>" +
          obj.address +
          "</th>" +
          "<th>" +
          obj.active +
          "</th>" +
          "</tr>";
        // }
      }
    })
    .fail((obj, textStatus) => {
      if ((obj && obj.responseJSON, obj.responseJSON.message)) {
        alert(obj.responseJSON.message);
      }
    });
};
const submitBtn = document.getElementById("submitbtn");
submitBtn.addEventListener("click", addStudent);

const searchBtn = document.getElementById("searchbtn");
searchBtn.addEventListener("click", getAllStudentsFromDb);
