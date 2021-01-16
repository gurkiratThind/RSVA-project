// var Cryptr = require('cryptr');
// cryptr = new Cryptr('myTotalySecretKey');

var connection = require("../config/config");
module.exports.authenticate = function (req, res) {
    var email = req.body.email;
    var password = req.body.password;


    connection.query('SELECT * FROM userss WHERE email = ?', [email], function (error, results, fields) {
        if (error) {
            console.log(error);
            res.json({
                status: false,
                message: 'there are some error with query'
            })
        } else {

            if (results.length > 0) {
                var p1 = results[0].password
                // decryptedString = cryptr.decrypt(results[0].password);
                if (password == p1) {
                    res.json({
                        status: true,
                        message: 'successfully authenticated'
                    })
                } else {
                    res.json({
                        status: false,
                        message: "Email and password does not match"
                    });
                }

            }
            else {
                res.json({
                    status: false,
                    message: "Email does not exits"
                });
            }
        }
    });
}
