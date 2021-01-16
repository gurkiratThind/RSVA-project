const express = require("express");
const connection = require("../config/config");

module.exports.mechanicsList = function (req, res) {
  let sp_id = req.body.sp_id;
  let sql = `SELECT * FROM mechanics Where (sp_id=?)`;
  connection.query(sql, sp_id, function (err, data, fields) {
    if (err) throw err;
    res.json({
      status: 200,
      data,
      message: "User lists retrieved successfully",
    });
  });
};
