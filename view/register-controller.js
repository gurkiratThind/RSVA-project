var express = require("express");
var connection = require("../config/config");
// cryptr = new Cryptr('myTotalySecretKey');

module.exports.register = function (req, res) {
  var today = new Date();
  //  var encryptedString = cryptr.encrypt(req.body.password);
  var users = {
    name: req.body.name,
    email: req.body.email,
    password: req.body.password,
    created_at: today,
    updated_at: today,
    image: req.file.path,
  };
  connection.query(
    "INSERT INTO userss SET ?",
    users,
    function (error, results, fields) {
      if (error) {
        res.json({
          status: false,
          message: "there are some errors with query!!!",
        });
      } else {
        res.json({
          status: true,
          data: results,
          message: "user registered sucessfully!! Great Work",
        });
      }
    }
  );
};
module.exports.login = function (req, res) {
  var today = new Date();
  //  var encryptedString = cryptr.encrypt(req.body.password);
  var users = {

    email: req.body.email,
    password: req.body.password,

  };
  connection.query(
    "INSERT INTO userss SET ?",
    users,
    function (error, results, fields) {
      if (error) {
        res.json({
          status: false,
          message: "there are some errors with query!!!",
        });
      } else {
        res.json({
          status: true,
          data: results,
          message: "user registered sucessfully!! Great Work",
        });
      }
    }
  );
};
