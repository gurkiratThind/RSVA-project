const express = require("express");
const connection = require("../config/config");

module.exports.mechanicsList = function (req, res) {
  let sp_id = req.body.sp_id;
  console.log("sp_id" + sp_id);
  let sql = `SELECT * FROM mechanics Where sp_id=${sp_id}`;
  connection.query(sql, function (err, data, fields) {
    if (err) throw err;
    console.log(sql);
    console.log(data);
    res.json({
      status: 200,
      data,
      message: "User lists retrieved successfully",
    });
  });
};
