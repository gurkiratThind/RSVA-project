var express = require("express");
var bodyParser = require("body-parser");
var multer = require("multer");
var cors = require("cors");
const fs = require("fs");
var connection = require("./../config/config");
var app = express();
app.use("./uploads/", express.static("uploads"));
//var authenticateController = require("./controllers/authenticate-controller");
var registerController = require("./register-controller");

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cors());

const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    fs.mkdir("./uploads/", (err) => {
      cb(null, "./uploads/");
    });
  },
  filename: function (req, file, cb) {
    console.log(file);
    cb(null, new Date().toISOString().replace(/:/g, "-") + file.originalname);
  },
});

const fileFilter = (req, file, cb) => {
  if (file.mimetype === "image/jpeg" || file.mimetype === "image/png") {
    cb(null, true);
  } else {
    cb(null, false);
  }
};

const upload = multer({
  storage: storage,
  limits: {
    fileSize: 1024 * 1024 * 5,
  },
  fileFilter: fileFilter,
});

//const upload = multer({ dest: "uploads/" }).single("image");

app.post("/api/register", upload.single("image"), registerController.register);

app.post("/image", (req, res) => {
  upload(req, res, (err) => {
    if (err) {
      res.status(400).send("Something went wrong!");
    }
    res.send(req.file);
  });
});
//app.post("/api/authenticate", authenticateController.authenticate);

//console.log(authenticateController);
app.post("/controllers/register-controller", registerController.register);
// app.post(
//   "/controllers/authenticate-controller",
//   authenticateController.authenticate
// );
app.listen(8012);
