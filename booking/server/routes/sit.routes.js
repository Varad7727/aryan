const express = require("express");
const router = express.Router();
const { getSeatController } = require("../controller/sit.controller");

router.get("/:tripId", getSeatController);
module.exports = router;
