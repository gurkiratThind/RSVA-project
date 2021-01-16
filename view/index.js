const express = require("express");
const bodyParser = require("body-parser");
const multer = require("multer");
const cors = require("cors");
const fs = require("fs");
const connection = require("./../config/config");
const app = express();
app.use("./uploads/", express.static("uploads"));
//var authenticateController = require("./controllers/authenticate-controller");
const registerController = require("./register-controller");
const cst = require("./client_speciality");

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

var cpUpload = upload.fields([
  { name: "mechphoto", maxCount: 1 },
  { name: "shopphoto", maxCount: 8 },
]);
//const upload = multer({ dest: "uploads/" }).single("image");

app.post("/api/register", cpUpload, registerController.register);

//app.post("/api/authenticate", authenticateController.authenticate);

//console.log(authenticateController);
app.post("/controllers/register-controller", registerController.register);
app.get("/clientspeciality", cst.clientSpeciality);
// app.post(
//   "/controllers/authenticate-controller",
//   authenticateController.authenticate
// );
app.listen(8012);
