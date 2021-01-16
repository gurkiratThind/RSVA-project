const express = require("express");
const connection = require("../config/config");

module.exports.clientSpeciality = function (req, res) {
  let sql = `SELECT * FROM client_speciality`;
  connection.query(sql, function (err, data, fields) {
    if (err) throw err;
    res.json({
      status: 200,
      data,
      message: "User lists retrieved successfully",
    });
  });
};
