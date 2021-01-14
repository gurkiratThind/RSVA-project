var mysql = require("mysql");
var connection = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "020593",
  database: "mydb",
});
connection.connect(function (err) {
  if (!err) {
    debugger;
    console.log("Database is connected");
  } else {
    console.log("Error while connecting with database");
  }
});
module.exports = connection;
