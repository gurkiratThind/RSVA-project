const express = require("express");
const connection = require("../config/config");
// cryptr = new Cryptr('myTotalySecretKey');

module.exports.register = function (req, res) {
  let today = new Date();
  console.log(req.file);
  //  var encryptedString = cryptr.encrypt(req.body.password);
  // var base64Data = req.rawBody.replace(/^data:image\/png;base64,/, "");
  var users = {
    mechname: req.body.mechname,
    mechemail: req.body.mechemail,
    opendays: req.body.opendays,
    opentime: today,
    closetime: today,
    mechphoto: req.files["mechphoto"].buffer,
    shopphoto: req.files["shopphoto"].buffer,
    phoneno: req.body.phoneno,
    shopname: req.body.shopname,
    sp_id: req.body.sp_id,
    lat: req.body.lat,
    long: req.body.long,
    password: req.body.password,
    shopaddress: req.body.shopaddress,
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
