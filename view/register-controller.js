const express = require("express");
const connection = require("../config/config");
// cryptr = new Cryptr('myTotalySecretKey');

module.exports.register = function (req, res) {
  let today = new Date();
  mechphotos = req.files["mechphoto"];
  console.log(mechphotos);
  var users = {
    mechname: req.body.mechname,
    mechemail: req.body.mechemail,
    opendays: req.body.opendays,
    opentime: today,
    closetime: today,
    mechphoto: req.files["mechphoto"],
    shopphoto: req.files["mechphoto"],
    phoneno: req.body.phoneno,
    shopname: req.body.shopname,
    sp_id: req.body.sp_id,
    lat: req.body.lat,
    long: req.body.long,
    password: req.body.password,
    shopaddress: req.body.shopaddress,
    basic_rate: req.body.basic_rate,
  };
  connection.query(
    "INSERT INTO mechanics SET ?",
    users,
    function (error, results, fields) {
      if (error) {
        console.log(error);
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
